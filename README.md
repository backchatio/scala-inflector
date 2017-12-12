# Scala Inflector 

Ports the ruby rails inflector code to scala.  
Includes specs for the inflections.  

You can use the inflections either as an object:
  
```scala
import mojolly.inflector.Inflector

Inflector.singularize("sheep") 
```  

or as an implicit:  

```scala
import mojolly.inflector.InflectorImports._ // this is also a trait

"sheep".singularize
```

## Downloading

This library is published to maven-central.

```scala
libraryDependencies += "io.backchat.inflector" %% "scala-inflector" % "1.3.6"
```

## Patches
Patches are gladly accepted from their original author. Along with any patches, please state that the patch is your original work and that you license the work to the *rl* project under the MIT License.

## License
MIT licensed. check the [LICENSE](https://github.com/mojolly/scala-inflector/blob/master/LICENSE) file
