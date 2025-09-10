#!/bin/bash
#

set -e
set -u

# -------------------------------------------
# 			Rappel
# -------------------------------------------
#
# Separateur:
#
#		Windows		;
#		Linux/Mac	: 
#
# Classpath:
#
#		Acronyme
#
# 		-cp
#	
#		Configuration
#
# 		.			=> 	met dans le cp tous       .class   du repertoire courant 
# 		./*			=> 	met dans le cp tous les    jar     du repertoire courant
#		./ext/* 	=>	met dans le cp tous les    jar	   du folder ext
# 
# Memory:
#
# 	-Xms200m	memoire reservee par l'OS, que la jvm l'emploie ou pas!
# 	-Xmx500m	memoire max que l'OS peut allouer au processus
#
# 	-verbose:gc		=> utile pour optimisation, affiche l'activite du garbage collector  (Warning: ne pas livrer chez le client)
#
# Assertion:
#
#		-ea  	enable assertion
#		-da		disable assertion
#
# System Properties :
#	
#		-Da=1 -Dc=3 -Db=3.14
#

# -------------------------------------------
# 			Linux specific
# -------------------------------------------

# Warning:
#
#		(W1) Lisez ../linux/installJava.sh
#
#		(W2) Lisez ../linux/tips.txt
#

# -------------------------------------------
# 			Debug
# -------------------------------------------

#java -version
#echo ""

# -------------------------------------------
# 			Run
# -------------------------------------------

#java -cp .:./*:./ext/*  ch.hearc.a_kitbase.container.tab.mono.quadratique.UseQuadratiqueArgs -8 -2 3
java -cp .:./*:./ext/* ch.hearc.dice.moo.implementation.Dice.UseSpeedUPDice

# -------------------------------------------
# 			end
# -------------------------------------------

echo ""
