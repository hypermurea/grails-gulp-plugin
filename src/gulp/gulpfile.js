var gulp = require('gulp');
var gutil = require('gulp-util');
var jasmine = require('gulp-jasmine');

gulp.task('test', function () {
    gulp.src('spec/test.js')
        .pipe(jasmine());
});

gulp.task('default', function() {
	// TODO	
});