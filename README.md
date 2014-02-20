# Grails Gulp Plugin

Integrates Gulp tasks with Grails. You can call gulp tasks from Grails command-line and link tasks to project compilation and test phases.

Heavily WIP

## Installation

Install node.js. Then install Gulp with gulp npm install gulp -g. 

Add the plugin to your grails-app/conf/BuildConfig.groovy:

plugins {
	compile ":gulp:latest.version"
}

## Configuration

The installation creates grails/app/conf/GulpConfig.groovy. Modify this sample file to specify tasks to invoke together with Grails compile and unit-test phases.

## Commands

You can invoke gulp [task1] [task2] [...] from the grails command-line to start Gulp tasks. gulp without parameters will invoke the default task.

## Recipes



