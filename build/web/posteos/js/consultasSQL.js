//buscar ultimo comentario

SELECT com_autor, com_mensaje FROM `comentarios` WHERE com_orden=(select max(com_orden) from comentarios)


//buscar comentarios ordenados

SELECT com_autor, com_mensaje FROM `comentarios` WHERE com_id = X ORDER BY com_orden DESC


//contador de mensajes por usuario

SELECT COUNT(com_id) FROM comentarios WHERE com_autor = X; 