
INSERT INTO `roles` (`role_asignado`) VALUES ('Coordinador')
INSERT INTO `roles` (`role_asignado`) VALUES ('Director')
INSERT INTO `roles` (`role_asignado`) VALUES ('Miembro del comite')

INSERT INTO `docentes` (`nombre_grupo`, `apellidos_docente`, `correo`, `nombres_docente`) VALUES ('Grupo A','Perez','Juan.perez@universidad.edu','juan')
INSERT INTO `docentes` (`nombre_grupo`, `apellidos_docente`, `correo`, `nombres_docente`) VALUES ('Grupo B','Benavides','kellyb@universidad.edu','kelly')
INSERT INTO `docentes` (`nombre_grupo`, `apellidos_docente`, `correo`, `nombres_docente`) VALUES ('Grupo C','Robledo','kensllyb@universidad.edu','Evelin')
INSERT INTO `docentes` (`nombre_grupo`, `apellidos_docente`, `correo`, `nombres_docente`) VALUES ('Grupo D','Lopez','david@universidad.edu','David')
INSERT INTO `docentes` (`nombre_grupo`, `apellidos_docente`, `correo`, `nombres_docente`) VALUES ('Grupo A','martinez','rosab@universidad.edu','Rosa')

INSERT INTO `historicos` (`activo`, `fechaFin`, `fechaInicio`, `idFkDocente`, `idFkRol`) VALUES (true, '2023-01-01', '2023-12-31', 1, 3)
INSERT INTO `historicos` (`activo`, `fechaFin`, `fechaInicio`, `idFkDocente`, `idFkRol`) VALUES (false, '2022-01-01', '2022-12-31', 2, 2) 
INSERT INTO `historicos` (`activo`, `fechaFin`, `fechaInicio`, `idFkDocente`, `idFkRol`) VALUES (true, '2023-06-01', '2024-06-01', 3, 3) 
INSERT INTO `historicos` (`activo`, `fechaFin`, `fechaInicio`, `idFkDocente`, `idFkRol`) VALUES (true, '2024-01-01', '2024-12-31', 4, 2) 
INSERT INTO `historicos` (`activo`, `fechaFin`, `fechaInicio`, `idFkDocente`, `idFkRol`) VALUES (false, '2021-01-01', '2021-12-31', 5, 3) 
