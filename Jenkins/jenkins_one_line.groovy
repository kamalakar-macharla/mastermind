
NODELEBEL passed from the jenkins job.
node('env.NODELEBEL'){ 
    stage('build'){
      bat "command";
      sh "command";
      powershell '''    '''

    }
}

parameterlised build - string , choice parameter

Basic steps

isUnix
    deleteDir
    dir
        pwd
        fileExists
            readFile
            writeFile
                archive
                unarchive


echo         # this echo mentiond in jenkins basic steps doc
error
sleep
retry
timeout

withEnv
withCredentials

withEnv(['MYTOOL_HOME=/usr/local/mytool']) {
    sh '$MYTOOL_HOME/bin/start'
  }

withEnv([
  "ter_host=${THOST}",
  "cr_user=${CUSER}",
  "cr_pwd=${CPWD}",
  "des_dir=${Des_DIR}"
  ]) {
}


Credentials Binding Plugin
withCredentials([
          usernamePassword(credentialsId: 's3_za_qauat_new', usernameVariable: 'USER_qauat', passwordVariable: 'PWD_qauat'),
          usernamePassword(credentialsId: 's3_za_prod', usernameVariable: 'USER_prod', passwordVariable: 'PWD_prod')
        ]) {



import groovy.io.FileType.*;
def myvar // def accept any time.

node(_nodeLabel) {
  deleteDir();
  init();
  execute();
}

_nodeOs = isUnix() ? _linux : _windows;
_commonUtils = load "./pipeline-utilities/common.groovy";
_commonUtils.prepareStages(_stageCheckoutPipeline,_stageCheckoutProject,_stageBuildAutomation,_stageBuildManagement,);



_pipelineProps = readProperties file: "$_dirPipelineRepo\\$_gitPipelineRepositoryFolder\\$_pipelinePropertyFile";
env.projDesc = _pipelineProps.PROJECT_NAME;

 build job: '/globe/S3-vb6/dev-ci-cd/utils/deploy-component', parameters: [
            string(name: 'PipelineRepository',value: _gitPipelineRepository),
            string(name: 'PipelineBranch', value: _gitPipelineRepositoryBranch),
            string(name: 'DeploymentType', value: "Exe"),
            string(name: 'Exe', value: _ExeFile),
            string(name: 'BuildNode', value: _nodeLabel)
            ];



node(_nodeLabel) {
    try
    {
    }
    catch(Exception e) {
        println e;
        throw e;
    }
    finally {
        deleteDir();
    }
}


def server = Artifactory.server 'my-server-id'
If your Artifactory is not defined in Jenkins you can still create it as follows:
def server = Artifactory.newServer url: 'artifactory-url', username: 'username', password: 'password'

def downloadSpec = """{
 "files": [
  {
      "pattern": "bazinga-repo/*.zip",
      "target": "bazinga/"
    }
 ]
}"""
server.download spec: downloadSpec

def uploadSpec = """{
  "files": [
    {
      "pattern": "bazinga/*froggy*.zip",
      "target": "bazinga-repo/froggy-files/"
    }
 ]
}"""
server.upload spec: uploadSpec

server.download spec: downloadSpec, failNoOp: true
server.upload spec: uploadSpec, failNoOp: true



