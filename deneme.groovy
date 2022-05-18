properties([
    parameters([
        string(description: 'Enter Linux IP', name: 'IP')
    ])
])

node {
    
    stage('Clone the repository') {
        git branch: 'main', url: 'https://github.com/ucanozyurteri/school.git'
    }
    
    stage('Add user on Test Machine') {
        ansiblePlaybook credentialsId: 'jenkins-key', inventory: "$params.IP", playbook: 'add_user.yaml'
    }
}
