includeTargets << grailsScript("_GrailsInit")

printMessage = { String message -> event('StatusUpdate', [message]) }

target(main: "Run a gulp task") {
	
	//ant.exec(executable:"gulp", dir: "${basedir}/src/gulp")
	//printMessage "running gulp task"
}

setDefaultTarget(main)
