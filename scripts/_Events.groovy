includeTargets << new File(gulpPluginDir, 'scripts/_GulpCommands.groovy')

eventTestPhaseStart = { phase -> 
	if(phase == 'unit') {
		runTestTasks()
	}
}

eventCompileStart = {
	runCompileTasks()
}