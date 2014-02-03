includeTargets << grailsScript('_GrailsInit')
includeTargets << new File(gulpPluginDir, 'scripts/_GulpCommands.groovy')

target(main: 'Run gulp default task or a list of tasks given as parameters') {
	def gulpCommand = 'gulp'
	for (name in argsMap["params"]) {
		gulpCommand += ' ' + name
	}
	pluginShell(gulpCommand)
}

setDefaultTarget(main)
