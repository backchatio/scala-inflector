# Scala Inflector 

Ports the ruby rails inflector code to scala.  
Includes specs for the inflections.  

You can use the inflections either as an object  
```scala
Inflector.singularize("sheep") 
```  
or as an implicit:  
```scala
"sheep".singularize
```