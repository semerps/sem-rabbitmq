grails.project.work.dir = 'target'

grails.project.dependency.resolution = {
    inherits 'global'
    log "warn"

    repositories {
        grailsCentral()
        mavenLocal()
        mavenCentral()

        mavenRepo "https://repo.grails.org/grails/plugins"
    }

    dependencies {
        compile 'com.rabbitmq:amqp-client:3.5.0'
        test('org.objenesis:objenesis:2.1') {
            export = false
        }
    }

    plugins {
        build ":release:1.1.0", {
            export = false
        }
        test(":spock:0.7", ":code-coverage:1.2.7") {
            export = false
        }
    }
}
