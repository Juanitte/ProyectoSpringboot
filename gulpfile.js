const gulp = require('gulp');
const sass = require('gulp-sass')(require('sass'));
const sourcemaps = require('gulp-sourcemaps');
const autoprefixer = require('gulp-autoprefixer');
const cleanCSS = require('gulp-clean-css');
const rename = require('gulp-rename');

// Tarea para compilar el archivo SCSS
gulp.task('sass', function () {
  return gulp
    .src('src/main/resources/static/style.scss')
    .pipe(sourcemaps.init())
    .pipe(sass().on('error', sass.logError))
    .pipe(autoprefixer())
    .pipe(cleanCSS())
    .pipe(rename({ suffix: '.min' }))
    .pipe(sourcemaps.write('.'))
    .pipe(gulp.dest('src/main/resources/static'));
});

// Tarea de vigilancia para la compilación automática cuando se detectan cambios en el archivo SCSS
gulp.task('watch', function () {
  gulp.watch('src/main/resources/static/style.scss', gulp.series('sass'));
});

// Tarea predeterminada que ejecuta las tareas "sass" y "watch" al mismo tiempo
gulp.task('default', gulp.parallel('sass', 'watch'));