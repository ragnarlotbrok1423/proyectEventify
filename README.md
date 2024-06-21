> [!IMPORTANT]
> Cuando clones el repositorio debes esperar que todo el proyecto cargue completamente antes de empezar a poner codigo, de lo contrario puedes romper tu proyecto

#  Proyect Eventify

Este proyecto Buscara crear una relación entre todos los estudiantes de la U en la cual podran compartir sus conocimientos y experiencias con diferentes materias 
o profesores ademas de calificar a los mismos, a su vez los profesores podran recibir un feedback de sus estudiantes sobre como mejorar sus clases
Ademas de que buscamos impulsar el emprendimiento de los estudiantes de la u mediante un apartado especial para emprendimientos en donde pueden promocionar su negocio

## ¿Comentar a los Profesores?

Si lo se, suena un poco toxico, pero en nuestro sistema ningun estudiante podra colocar su nombre sino que debera colocar un nickname ademas al momento de comentar 
en el apartado para calificar a profesores y comentarlos no se revelara ninguna informacion relevante aserca del estudiante, a su vez los profesores solamente podran observar
de manera resumida sus calificaciones y podra ser comparado con otros profesores

> [!IMPORTANT]
> Github flow y VIPER son 2 cosas diferentes uno es una forma de trabajar repositorios y la otra es un patron de arquitectura de software

## Forma de Trabajo
primero comenzaremos conociendo la forma en la que vamos a trabajar en este repositorio

### GitHub Flow
con este workflow vamos a trabajar de la siguiente manera, tendremos 2 ramas una es el main y la otra rama dev, en la rama dev es en la que nos debemos centrar ya que apatir de esta rama 
vamos a crear las demas, cuando se necesite crear cualquier funcionalidad es donde se debe crear una nueva rama, ejemplo: para las personas de diseño el crear una vista completa es motivo para crear una nueva rama, primero se crea la rama y luego se verifica que efectivamente estemos sobre la rama que creamos y ya podremos añaidr codigo, la creacion de las rama tienen una nomenclatura en el nombre de la rama que debemos seguir: `features_queEstamosHaciendo_queHace` para ejemplificar mejor podria ser asi: `features_views_login` o podria ser tambien `features_interactors_crateUser` ya cuando creas de que has terminado la tarea por la cual creaste la rama vas a proceder a realizar un pull reques en el deberas poner un titulo y una descripcion corta clara y al grano y luego mandas el pull request para ser revisador, si el pull request no cumple con lo que promete hacer o hay algun error se mandara a correccion y cuando haga la correccion debera realizar un nuevo pull request y ese seria el funcionamiento de este repositorio

> [!TIP]
> Recuerde que estamos trabajando con xml y no con jetPackCompose 
