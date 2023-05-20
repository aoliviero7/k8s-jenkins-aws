node {

    stage("Git Clone"){

        git credentialsId: 'GIT_HUB_CREDENTIALS', url: 'https://github.com/aoliviero7/k8s-jenkins-aws',  branch: 'main'
    }

     stage('Gradle Build') {

       sh './gradlew build'

    }

    stage("Docker build"){
        sh 'docker version'
        sh 'docker build -t jhooq-docker-demo .'
        sh 'docker image list'
        sh 'docker tag jhooq-docker-demo alessandroliviero/jhooq-docker-demo:jhooq-docker-demo'
        sh 'docker login -u alessandroliviero -p %VuzKw5CKdBuk?s'
    }



    stage("Push Image to Docker Hub"){
        sh 'docker push  alessandroliviero/jhooq-docker-demo:jhooq-docker-demo'
    }
    
    stage("kubernetes deployment"){
        sh 'sudo kubectl rollout restart deployment data-manager'
        //sh 'sudo kubectl apply -f k8s-spring-boot-deployment.yml'
    }
} 
