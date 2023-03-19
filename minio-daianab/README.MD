**#Parcial Backend 2**

**###Resumen:**
Cree y configuré un reino en Keyclok que se llama "Digital-media", en él comencé una estrategia de autorización
para proteger los diferentes microservicios del sistema.
Tenemos 4 usuarios que consumen diferentes API´s:
-Clientes
-Administradores
-Proveedores de facturas
-Sistemas internos

Utilizando **GBAC** cree 3 grupos para algunos de los usuarios anteriormente mencionados. Configuré los consentimientos
de Keyclok necesarios.
Configuré un microservicio como servidor de recursos y restringí los endpoints solo a usuarios autenticados, para que 
solo puedan consumir la API los que tengan un token válido. Luego mapee las urls de los microservicios de usuarios, 
peliculas y facturación, agregando también el filtro de TokenRelay con las configuraciones de credencial de Keyclok que
tenía.
Basandome en los grupos **GBAC** modifiqué los roles asociados a los usuarios autenticados para que exista un control 
sobre el acceso a los determinados recursos.
Hice una delegación en los usuarios administradores para que puedan gestionar usuarios en Keyclok desde el microservicio
>user-service.

Por último configuré el uso de Feign con OAuth en >facturacion-service.

***

**###Importante:**
Una vez que comencé el punto 5 dejó de compilar el programa.
En cuánto a la configuración de Feign no estoy segura de haberla hecho cómo corresponde, ya que no pude profundizar
mucho sobre ella y tampoco pude revisarlo bien debido a la compilación.