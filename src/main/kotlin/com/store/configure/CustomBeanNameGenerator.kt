package com.store.configure

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.beans.factory.support.BeanDefinitionRegistry
import org.springframework.beans.factory.support.BeanNameGenerator
import org.springframework.context.annotation.AnnotationBeanNameGenerator
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RestController

class CustomBeanNameGenerator : BeanNameGenerator {
    private val defaultGenerator = AnnotationBeanNameGenerator()

    override fun generateBeanName(definition: BeanDefinition, registry: BeanDefinitionRegistry): String {
        if (isController(definition)) {
            return generateFullBeanName(definition as AnnotatedBeanDefinition)
        }

        return this.defaultGenerator.generateBeanName(definition, registry)
    }

    private fun generateFullBeanName(definition: AnnotatedBeanDefinition): String {
        return definition.metadata.className
    }

    private fun getAnnotationTypes(definition: BeanDefinition): Set<String> {
        val annotatedDef = definition as AnnotatedBeanDefinition
        val metadata = annotatedDef.metadata
        return metadata.annotationTypes
    }

    private fun isController(definition: BeanDefinition): Boolean {
        if (definition is AnnotatedBeanDefinition) {
            val annotationTypes = getAnnotationTypes(definition)

            for (annotationType in annotationTypes) {
                if (annotationType == Controller::class.java.name) {
                    return true
                }
                if (annotationType == RestController::class.java.name) {
                    return true
                }
            }
        }
        return false
    }
}
