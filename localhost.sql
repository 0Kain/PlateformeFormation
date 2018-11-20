-- phpMyAdmin SQL Dump
-- version 4.0.10deb1ubuntu0.1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Mar 20 Novembre 2018 à 09:56
-- Version du serveur: 5.5.62-0ubuntu0.14.04.1
-- Version de PHP: 5.5.9-1ubuntu4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `platform`
--

-- --------------------------------------------------------

--
-- Structure de la table `articles`
--

CREATE TABLE IF NOT EXISTS `articles` (
  `id` int(250) NOT NULL AUTO_INCREMENT,
  `sujet` varchar(100) DEFAULT NULL,
  `titre` varchar(100) DEFAULT NULL,
  `keywords` varchar(100) DEFAULT NULL COMMENT 'Les mots cles qui pourront etre recherchés dans l''article',
  `auteur` varchar(100) DEFAULT NULL,
  `date-creation` date DEFAULT NULL,
  `date-modif` date DEFAULT NULL,
  `contenu` varchar(100) DEFAULT NULL,
  `references` varchar(100) DEFAULT NULL COMMENT 'la liste des URL',
  `resume` varchar(50) DEFAULT NULL COMMENT 'Resumé de  de l''article',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `articles`
--

INSERT INTO `articles` (`id`, `sujet`, `titre`, `keywords`, `auteur`, `date-creation`, `date-modif`, `contenu`, `references`, `resume`) VALUES
(1, 'math', 'probabilités et statistiques', NULL, 'mame', '2018-10-21', '2018-10-22', NULL, NULL, ''),
(2, 'Informatique', 'JAVA', NULL, 'Adan', '2018-10-15', '2018-10-23', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `dictionnaire`
--

CREATE TABLE IF NOT EXISTS `dictionnaire` (
  `id_mc` int(11) NOT NULL AUTO_INCREMENT,
  `mots_cles` varchar(100) NOT NULL,
  `poids` int(11) NOT NULL,
  PRIMARY KEY (`id_mc`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `sujet`
--

CREATE TABLE IF NOT EXISTS `sujet` (
  `id_sujet` int(11) NOT NULL AUTO_INCREMENT,
  `nom_sujet` varchar(100) NOT NULL,
  `sujets_parents` varchar(100) NOT NULL,
  PRIMARY KEY (`id_sujet`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id_user` int(1) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `pseudo` varchar(50) NOT NULL,
  `roles` varchar(50) NOT NULL DEFAULT 'lecteur',
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`id_user`, `prenom`, `nom`, `pseudo`, `roles`) VALUES
(0, 'baye', 'tine', 'bayetine', 'utilisateur'),
(1, 'yanis', 'al garib', 'yanis_elgab', 'lecteur'),
(2, 'valentin', 'courtois', 'val_courtois', 'lecteur');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
