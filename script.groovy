def build(){
  echo "Building"
}
def test(){
  sh "ls"
  echo "Testing"
}
def deploy(){
  echo "Deploying version ${params.VERSION}"
}
return this
