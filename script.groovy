def build(){
  echo "Building"
}
def test(){
  echo "Testing"
}
def deploy(){
  echo "Deploying version ${params.VERSION}"
}
return this
