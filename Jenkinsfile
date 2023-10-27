pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Récupérer le code depuis Git
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Exécuter les étapes de construction ici
                // Par exemple, utiliser Maven pour construire le  projet
                sh 'mvn clean package'
            }
        }
    }

    post {
        success {
            // En cas de réussite de la construction, vous pouvez ajouter des actions supplémentaires ici
            echo 'La construction a réussi. Faire quelque chose de plus si nécessaire.'
        }

        failure {
            // En cas d'échec de la construction, vous pouvez ajouter des actions supplémentaires ici
            echo 'La construction a échoué. Faire quelque chose de plus si nécessaire.'
        }
    }
}
