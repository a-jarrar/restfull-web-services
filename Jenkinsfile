pipeline {
agent any
stages {
stage('stage1') {
steps{
echo 'pull the latest commit'
sh 'sudo git -C /root/java pull'
sh 'sudo chmod +x /root/java/mvnw'
sh 'sudo tmux kill-session -t test_api || echo'
sh 'sudo sh -c "cd /root/java && sudo tmux new-session -d -s test_api \'/root/java/mvnw spring-boot:run\'"'
}
}
}
}
