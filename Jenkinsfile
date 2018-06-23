node {
    def commit_id
    def buildStatus
    try {
        stage('Preparation') {
            checkout scm
            sh "git rev-parse --short HEAD > .git/commit-id"
            commit_id = readFile('.git/commit-id').trim()
        }
        stage('Build & Test') {
            def gradle = docker.image('gradle:4.8-jdk10')
            gradle.pull()
            gradle.inside() {
                sh 'gradle -Dorg.gradle.daemon=false clean -x test build bootJar'
            }
        }

        stage('docker build/push') {
            docker.withRegistry('https://index.docker.io/v1/', 'dockerhub') {
                def image = docker.build("kozhenkov/link-aggregator-backend:${commit_id}", '-f docker/Dockerfile .')
                //image.push()
                image.push('latest')
                sh "docker rmi kozhenkov/link-aggregator-backend:${commit_id}"
            }
        }
        buildStatus = 'Successful'
    } catch (e) {
        echo e
        buildStatus = 'Failure'
    }

    withCredentials([string(credentialsId: 'telegram_token', variable: 'telegram_token')]) {
        echo "Sending telegram message..."
        def chatId = '131116969'
        def message = java.net.URLEncoder.encode(
                "Revision #${commit_id} - Build status: ${buildStatus}", "UTF-8")
        httpRequest "https://api.telegram.org/bot${telegram_token}/sendMessage?chat_id=${chatId}&text=${message}"
    }
}