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

includeTargets << grailsScript('_GrailsInit')
includeTargets << new File(gulpPluginDir, 'scripts/_GulpCommands.groovy')

ant.mkdir(src:"${basedir}/src/gulp")
ant.mkdir(src:"${basedir}/src/gulp/spec")
ant.copy(file: "${pluginBasedir}/src/gulp/gulpfile.js", todir: "${basedir}/src/gulp")
ant.copy(file: "${pluginBasedir}/src/gulp/package.json", todir: "${basedir}/src/gulp")
ant.copy(file: "${pluginBasedir}/src/gulp/spec/test.js", todir: "${basedir}/src/gulp/spec")

if(!pluginShell('npm install')) {
	event('StatusError',  'cannot execute npm: check that you have node.js, npm and gulp globally installed and on your PATH.')
}