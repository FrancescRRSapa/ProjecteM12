CREATE DATABASE projectePROVA;

USE projectePROVA;

CREATE TABLE `certificacions` (
  `id_certificacio` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `descripcio` text NOT NULL,
  `data_publicacio` date NOT NULL,
  `nivell_alumne_recomanat` varchar(100) NOT NULL,
  `tarifes` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `codis_mos`
--

CREATE TABLE `codis_mos` (
  `usuari` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `practice_test` varchar(100) NOT NULL,
  `examen` varchar(100) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `usuari_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `codis_mos`
--

INSERT INTO `codis_mos` (`usuari`, `password`, `practice_test`, `examen`, `date`, `usuari_id`) VALUES
('mtapt19-551', 'leiFuaH5iM', '00014-PALOMERA-94300', '1', '2020-06-13 08:37:54', 0),
('mtapt19-552', 'Eekei0iedu', '00024-PALOMERA-31111', '2', '2020-06-13 08:37:54', 0),
('mtapt19-553', 'Quah5engut', '00121-PALOMERA-59240', '3', '2020-06-13 08:37:54', 0),
('mtapt19-554', 'Aichoh4eew', '00145-PALOMERA-12430', '4', '2020-06-13 08:37:54', 0),
('mtapt19-555', 'aje7aeChei', '00153-PALOMERA-18946', '5', '2020-06-13 08:37:54', 0),
('mtapt19-556', 'uf5aeboe4I', '00169-PALOMERA-68757', '6', '2020-06-13 08:37:54', 0),
('mtapt19-557', 'iethuMeij6', '00244-PALOMERA-43719', '7', '2020-06-13 08:37:54', 0),
('mtapt19-558', 'awoopoi3eT', '00299-PALOMERA-11818', '8', '2020-06-13 08:37:54', 0),
('mtapt19-559', 'IeChoi0Esh', '00374-PALOMERA-49172', '9', '2020-06-13 08:37:54', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `codis_mta`
--

CREATE TABLE `codis_mta` (
  `usuari` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `practice_test` varchar(100) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `usuari_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `codis_mta`
--

INSERT INTO `codis_mta` (`usuari`, `password`, `practice_test`, `date`, `usuari_id`) VALUES
('mtapt19-551', 'leiFuaH5iM', '00014-PALOMERA-94300', '2020-06-13 08:29:32', 0),
('mtapt19-552', 'Eekei0iedu', '00024-PALOMERA-31111', '2020-06-13 08:29:32', 0),
('mtapt19-553', 'Quah5engut', '00121-PALOMERA-59240', '2020-06-13 08:29:32', 0),
('mtapt19-554', 'Aichoh4eew', '00145-PALOMERA-12430', '2020-06-13 08:29:32', 0),
('mtapt19-555', 'aje7aeChei', '00153-PALOMERA-18946', '2020-06-13 08:29:32', 0),
('mtapt19-556', 'uf5aeboe4I', '00169-PALOMERA-68757', '2020-06-13 08:29:32', 0),
('mtapt19-557', 'iethuMeij6', '00244-PALOMERA-43719', '2020-06-13 08:29:32', 0),
('mtapt19-558', 'awoopoi3eT', '00299-PALOMERA-11818', '2020-06-13 08:29:32', 0),
('mtapt19-559', 'IeChoi0Esh', '00374-PALOMERA-49172', '2020-06-13 08:29:32', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `concepte`
--

CREATE TABLE `concepte` (
  `id_concepte` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `data_alta` date NOT NULL,
  `data_baixa` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `configuracio`
--

CREATE TABLE `configuracio` (
  `codis_min` int(11) NOT NULL,
  `alumnes_aula` int(11) NOT NULL,
  `direccio_correu` varchar(100) NOT NULL,
  `contrasenya_correu` varchar(255) NOT NULL,
  `correu_envia_codis` text NOT NULL,
  `correu_envia_alerta_codis` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `configuracio`
--

INSERT INTO `configuracio` (`codis_min`, `alumnes_aula`, `direccio_correu`, `contrasenya_correu`, `correu_envia_codis`, `correu_envia_alerta_codis`) VALUES
(20, 15, 's.fernandez@sapalomera.cat', 'dr13LcphgkM=', '<p>A continuaci&oacute;n, te indicamos los pasos a seguir para acceder y utilizar correctamente el Practice Test de MOS:</p>\r\n<p>1)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Regristro en Gmetrix</p>\r\n<p>Crea una cuenta en Gmetrix desde este&nbsp;<a href=\"https://www.gmetrix.net/Public/Register.aspx\" target=\"_blank\" rel=\"noopener\" data-saferedirecturl=\"https://www.google.com/url?q=https://www.gmetrix.net/Public/Register.aspx&amp;source=gmail&amp;ust=1591030883428000&amp;usg=AFQjCNFQP1adFdP67rwlmdxde9FPwD_HUA\">enlace de registro</a>.</p>\r\n<p>2)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Acceso a nuestro entorno virtual</p>\r\n<p>Utiliza las siguientes credenciales para acceder a nuestro servidor remoto y poder realizar el Practice Test sin necesidad de descargar ning&uacute;n software.</p>\r\n<p>______________________________<wbr />____________________</p>\r\n<p><a href=\"https://trainingtest.pue.es/\" target=\"_blank\" rel=\"noopener\" data-saferedirecturl=\"https://www.google.com/url?q=https://trainingtest.pue.es/&amp;source=gmail&amp;ust=1591030883428000&amp;usg=AFQjCNHR103J1jFZt27g3Z8IqkXJTSAn7w\">Enlace de acceso</a></p>\r\n<p>Usuario: USERNAME</p>\r\n<p>Contrase&ntilde;a:&nbsp;CONTRASE&Ntilde;A</p>\r\n<p>______________________________<wbr />____________________</p>\r\n<p>3)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Inicio de sesi&oacute;n en Gmetrix</p>\r\n<p>Desde nuestro entorno remoto, haz click en el icono de Gmetrix e inicia sesi&oacute;n con la cuenta que has creado en Paso 1. Desde el panel izquierdo clicka en&nbsp;Activar c&oacute;digo (Redeem)&nbsp;e introduce el siguiente c&oacute;digo:</p>\r\n<p>______________________________<wbr />____________________</p>\r\n<p>C&oacute;digo: C&Oacute;DIGO PRACTICE TEST</p>\r\n<p>______________________________<wbr />____________________</p>\r\n<p>Te recomendamos que leas detenidamente el&nbsp;<a href=\"https://drive.google.com/file/d/1UtzrZdlun4orP0QtRRrCYXbtuvTlDpvt/view?usp=sharing\" target=\"_blank\" rel=\"noopener\" data-saferedirecturl=\"https://www.google.com/url?q=https://drive.google.com/file/d/1UtzrZdlun4orP0QtRRrCYXbtuvTlDpvt/view?usp%3Dsharing&amp;source=gmail&amp;ust=1591030883428000&amp;usg=AFQjCNFGLvYQnvoMuieWc9EvAdLQ8jpYWg\">manual de utilizaci&oacute;n</a>&nbsp;antes de iniciar el Practice Test.</p>\r\n<p>Ten en cuenta que la modalidad&nbsp;TRAINING&nbsp;permite realizar el Practice Test sin l&iacute;mite de tiempo, mientras que la modalidad&nbsp;TESTING&nbsp;activa una cuenta atr&aacute;s, con el mismo tiempo que el examen oficial.</p>\r\n<p>Una vez finalizado el Practice Test el programa nos emitir&aacute; un informe de resultados y dar&aacute; por concluido el simulacro de examen.</p>\r\n<p>IMPORTANTE: Para realizar el Practice Test de MOS es necesario disponer del software del fabricante instalado en tu equipo. Para m&aacute;s informaci&oacute;n, consulta por favor el siguiente&nbsp;<a href=\"https://support.gmetrix.net/download\" target=\"_blank\" rel=\"noopener\" data-saferedirecturl=\"https://www.google.com/url?q=https://support.gmetrix.net/download&amp;source=gmail&amp;ust=1591030883428000&amp;usg=AFQjCNHOYzoSmAPQ4xSfg98GOQ7XIPjngA\">enlace</a>.</p>', '<p>asda</p>');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grup_partit`
--

CREATE TABLE `grup_partit` (
  `id_grup_partit` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `data_alta` date NOT NULL,
  `data_baixa` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hora_examen`
--

CREATE TABLE `hora_examen` (
  `id_hora_examen` int(11) NOT NULL,
  `dia_setmana` date NOT NULL,
  `hora` varchar(5) NOT NULL,
  `tipus` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `hora_examen`
--

INSERT INTO `hora_examen` (`id_hora_examen`, `dia_setmana`, `hora`, `tipus`) VALUES
(1, '2020-05-30', '14:00', 'MTA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `id_reserva` int(11) NOT NULL,
  `id_usuari` int(11) NOT NULL,
  `id_hora_examen` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`id_reserva`, `id_usuari`, `id_hora_examen`) VALUES
(1, 1, 1),
(2, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarifa`
--

CREATE TABLE `tarifa` (
  `id_tarifa` int(11) NOT NULL,
  `id_grup_partit` int(11) NOT NULL,
  `id_concepte` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `preu` decimal(10,0) NOT NULL,
  `data_alta` date NOT NULL,
  `data_baixa` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuaris`
--

CREATE TABLE `usuaris` (
  `id_usuari` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `cognoms` varchar(50) NOT NULL,
  `dni` varchar(20) NOT NULL,
  `adreca` varchar(100) NOT NULL,
  `correu` varchar(50) NOT NULL,
  `telefon` varchar(9) NOT NULL,
  `password` varchar(255) NOT NULL,
  `tipus_usuari` varchar(50) NOT NULL,
  `llista_examens` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuaris`
--

INSERT INTO `usuaris` (`id_usuari`, `nom`, `cognoms`, `dni`, `adreca`, `correu`, `telefon`, `password`, `tipus_usuari`, `llista_examens`) VALUES
(1, 'Sergio', 'Fernández', '41529081M', 'c/maresme nº15', 's.fernandez@sapalomera.cat', '26', '1234', 'administrador', ''),
(2, 'Sergio', 'Fernández', '41529081M', 'c/maresme nº15', 's.fernandez@sapalomera.cat', '26', '1234', 'administrador', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuari_certificacio`
--

CREATE TABLE `usuari_certificacio` (
  `id_examen` int(11) NOT NULL,
  `id_usuari` int(11) NOT NULL,
  `id_certificacio` int(11) NOT NULL,
  `pagat` tinyint(1) NOT NULL,
  `data_solicitud` date NOT NULL,
  `data_pagament` date NOT NULL,
  `codi_id` varchar(50) NOT NULL,
  `estat` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `certificacions`
--
ALTER TABLE `certificacions`
  ADD PRIMARY KEY (`id_certificacio`);

--
-- Indices de la tabla `codis_mos`
--
ALTER TABLE `codis_mos`
  ADD PRIMARY KEY (`usuari`);

--
-- Indices de la tabla `codis_mta`
--
ALTER TABLE `codis_mta`
  ADD PRIMARY KEY (`usuari`);

--
-- Indices de la tabla `concepte`
--
ALTER TABLE `concepte`
  ADD PRIMARY KEY (`id_concepte`);

--
-- Indices de la tabla `grup_partit`
--
ALTER TABLE `grup_partit`
  ADD PRIMARY KEY (`id_grup_partit`);

--
-- Indices de la tabla `hora_examen`
--
ALTER TABLE `hora_examen`
  ADD PRIMARY KEY (`id_hora_examen`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`id_reserva`);

--
-- Indices de la tabla `tarifa`
--
ALTER TABLE `tarifa`
  ADD PRIMARY KEY (`id_tarifa`);

--
-- Indices de la tabla `usuaris`
--
ALTER TABLE `usuaris`
  ADD PRIMARY KEY (`id_usuari`);

--
-- Indices de la tabla `usuari_certificacio`
--
ALTER TABLE `usuari_certificacio`
  ADD PRIMARY KEY (`id_examen`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `concepte`
--
ALTER TABLE `concepte`
  MODIFY `id_concepte` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `grup_partit`
--
ALTER TABLE `grup_partit`
  MODIFY `id_grup_partit` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `hora_examen`
--
ALTER TABLE `hora_examen`
  MODIFY `id_hora_examen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `id_reserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `tarifa`
--
ALTER TABLE `tarifa`
  MODIFY `id_tarifa` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuaris`
--
ALTER TABLE `usuaris`
  MODIFY `id_usuari` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuari_certificacio`
--
ALTER TABLE `usuari_certificacio`
  MODIFY `id_examen` int(11) NOT NULL AUTO_INCREMENT;