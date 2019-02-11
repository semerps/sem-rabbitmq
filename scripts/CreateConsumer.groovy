
/**
 * @author Aaron Brown
 */
includeTargets << grailsScript("_GrailsInit")
includeTargets << grailsScript("_GrailsCreateArtifacts")

target(createConsumer: "Creates a new Rabbit-native Consumer class.") {
    depends(checkVersion, parseArguments)

    def type = "Consumer"
    promptForName(type: type)

    for (name in argsMap["params"]) {
        name = purgeRedundantArtifactSuffix(name, type)
        createArtifact(name: name, suffix: type, type: type, path: "grails-app/rabbit-consumers")
        createUnitTest(name: name, suffix: type)
    }
}

setDefaultTarget createConsumer
