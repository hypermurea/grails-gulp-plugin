includeTargets << grailsScript('_GrailsInit')

includeTool << gant.tools.Execute

getConfig = {
	def configFile = new File(basedir, 'grails-app/conf/GulpConfig.groovy')
	new ConfigSlurper().parse(configFile.text)
}

pluginShell = { command ->
	def success = true
	execute.shell('cd ' + basedir + '/src/gulp && ' + command, outProcessing: { printMessage it })
	
	success
}

runTestTasks = { 
	printMessage 'Running gulp test tasks'
	def testTasks = getConfig().grails.plugin.gulp.task.test
	pluginShell('gulp ' + testTasks)
	event('StatusFinal',  ['Finished gulp test tasks: ' + testTasks])
}

runCompileTasks = {
	printMessage 'Running gulp compile tasks'
	
	pluginShell('npm update') 
	def compileTasks = getConfig().grails.plugin.gulp.task.compile
	pluginShell('gulp ' + compileTasks)
	
	event('StatusFinal', ['Finished gulp compile tasks: ' + compileTasks])
}

printMessage = { String message -> event('StatusUpdate', [message + "\n" ]) }
