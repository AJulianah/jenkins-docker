def build(){
  echo "Building"
}
def test(){
  sh 'echo "Testing" > artefact.txt'
}
def deploy(){
  echo "Deploying version ${params.VERSION}"
}
return this
