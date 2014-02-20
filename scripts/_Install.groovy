//
// This script is executed by Grails after plugin was installed to project.
// This script is a Gant script so you can use all special variables provided
// by Gant (such as 'baseDir' which points on project base dir). You can
// use 'ant' to access a global instance of AntBuilder
//
// For example you can create directory under project tree:
//
//    ant.mkdir(dir:"${basedir}/grails-app/jobs")
//

includeTargets << new File(gulpPluginDir, 'scripts/_GulpCommands.groovy')

printMessage "installing Gulp plugin.."

printMessage "creating src/gulp"
ant.mkdir(dir:"${basedir}/src/gulp")
printMessage "creating src/gulp/spec"
ant.mkdir(dir:"${basedir}/src/gulp/spec")
printMessage "copying gulpfile.js"
ant.copy(file: "${pluginBasedir}/src/gulp/gulpfile.js", todir: "${basedir}/src/gulp")
printMessage "copying package.json"
ant.copy(file: "${pluginBasedir}/src/gulp/package.json", todir: "${basedir}/src/gulp")
printMessage "copying README.md"
ant.copy(file: "${pluginBasedir}/src/gulp/README.md", todir: "${basedir}/src/gulp/spec")
printMessage "copying test.js"
ant.copy(file: "${pluginBasedir}/src/gulp/spec/test.js", todir: "${basedir}/src/gulp/spec")
printMessage "copying GulpConfig.groovy"
ant.copy(file: "${pluginBasedir}/grails-app/conf/GulpConfig.groovy", todir: "${basedir}/grails-app/conf")

printMessage "running npm install.."

if(!pluginShell('npm install')) {
	event('StatusError',  'cannot execute npm: check that you have node.js, npm and gulp globally installed and on your PATH.')
}