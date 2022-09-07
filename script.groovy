def build(){
  echo "Building"
}
def test(){
  sh "groovy"
  echo "Testing"
}
def deploy(){
  echo "Deploying version ${params.VERSION}"
}
return this
