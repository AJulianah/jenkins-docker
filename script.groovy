def build(){
  echo "Building"
}
def test(){
  echo "Testing" > artefact.txt
}
def deploy(){
  echo "Deploying version ${params.VERSION}"
}
return this
