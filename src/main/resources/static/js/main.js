
var courseApi = Vue.resource('/allcourses{/id}');

Vue.component('course-row', {
    props: ['course'],
    template: '<div>{{ course.courseName }}:{{ course.theme }}:{{ course.lecturer }}</div>'
});

Vue.component('courses-list', {
    props: ['courses'],
    template: '<div><course-row v-for="course in courses" :key="course.id" :course="course"/></div>',
    created: function() {
        courseApi.get().then(
            result => result.json().then(
                data => data.forEach(course => this.courses.push(course))
            )
        )
    }
});

var app = new Vue({
    el: '#app',
    template: '<courses-list :courses="courses" />',
    data: {
        courses: []
    }
});