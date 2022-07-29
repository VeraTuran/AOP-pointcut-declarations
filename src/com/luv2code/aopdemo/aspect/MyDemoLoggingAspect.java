package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
//	// appliqué sur tt les méthodes d'un même package
//	// n'importe la classe(*.), methode(*) ou paramètre((..))
//	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")

	// Pour pouvoir réutiliser et mettre à jour le pointcut facilement on stocke sa
	// portée dans une *déclaration de pointcut*.
	// Elle a un peu l'air d'une méthode annoté de @Pointcut("execution (dont on
	// veut tenir compte)") mais elle agit plus comme une déclaration de variable.
	// Cette manière de faire permet en plus de combiner des expressions pointcut
	// entre eux.

	// la déclaration de point cut peut avoir n'importe quel nom
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	// on l'applique sur un advice comme ça:
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n----------> Executing @Before advice on addAccount()");
	}

	// demonstration que la déclaration de pointcut prend en compte tt les advice
	// auxquels elle a été ajouté:
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("\n----------> performing Api Analytics method");

	}
// Quand on combine des expressions pointcut on utilise les opérateurs logiques
// && (et) || (ou) et && !(ne pas). L'expression s'execute quand ça retourne
// "true" (pour "et" les deux conditions doivent être bon, pour "ou" l'une des
// deux doit être bon pour retourner "true", etc.) On va le mettre en pratique
// en appliquant une déclaration sur tout SAUF les getters et setters.

	// 1. créer DPC à combiner
	// 2. combiner DPC avec le premier
	// 3. appliquer DPC aux advices

	// demonstration d'utilisation d'une déclaration pointcut sur plusieurs advice:

}
