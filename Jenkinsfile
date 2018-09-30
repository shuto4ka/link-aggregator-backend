node {
    final SUCCESSFUL = 'Successful'
    final FAILURE = 'Failure'

    String commit_id
    String buildStatus
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
                def image = docker.build("kozhenkov/link-aggregator-backend:${commit_id}",
                        "--build-arg ${PROJECT_VERSION} -f docker/Dockerfile .")

                image.push('latest')

                sh "docker rmi kozhenkov/link-aggregator-backend:${commit_id}"
            }
        }
        buildStatus = SUCCESSFUL
    } catch (e) {
        echo e
        buildStatus = FAILURE
    }

    withCredentials([string(credentialsId: 'telegram_token', variable: 'telegram_token')]) {
        sendTelegramMessage("Revision #${commit_id} - Build status: ${buildStatus}", (String) telegram_token)

        if (buildStatus == SUCCESSFUL) {
            build 'link-aggregator-deploy'

            sendTelegramMessage("Revision #${commit_id} was deployed successfully", (String) telegram_token)
        }
    }
}

void sendTelegramMessage(String text, String telegram_token) {
    echo "Sending telegram message... - ${text}"

    def chatId = '131116969'
    def message = URLEncoder.encode(text, "UTF-8")

    httpRequest "https://api.telegram.org/bot${telegram_token}/sendMessage?chat_id=${chatId}&text=${message}"
}