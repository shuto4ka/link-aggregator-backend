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
            def gradle = docker.image('gradle:4.6-jdk9')
            gradle.pull()
            gradle.inside() {
                sh 'gradle -Dorg.gradle.daemon=false -x test build jar'
            }
//            agent {
//                docker {
//                    image 'gradle:4.6-jdk9'
//                    reuseNode true
//                    args '-u 1000:122 -v /srv/nfs/docker/host_volumes/gradle:/home/gradle/.gradle:rw -v /var/run/docker.sock:/var/run/docker.sock:rw -v /usr/bin/docker:/usr/bin/docker:ro'
//                }
//            }
//            steps {
//                withEnv(['LC_ALL=ru_RU.UTF-8']) {
//                    sh 'gradle -Dorg.gradle.daemon=false build test jar'
//                }
//            }
        }

//    stage('test with a DB') {
//        def mysql = docker.image('mysql').run("-e MYSQL_ALLOW_EMPTY_PASSWORD=yes")
//        def myTestContainer = docker.image('node:4.6')
//        myTestContainer.pull()
//        myTestContainer.inside("--link ${mysql.id}:mysql") {
//            // using linking, mysql will be available at host: mysql, port: 3306
//            sh 'npm install --only=dev'
//            sh 'npm test'
//        }
//        mysql.stop()
//    }
//    stage('docker build/push') {
//        docker.withRegistry('https://index.docker.io/v1/', 'dockerhub') {
//            def app = docker.build("kozhenkov/jenkins:${commit_id}", '.').push()
//        }
//    }
        buildStatus = 'Successful'
    } catch (e) {
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