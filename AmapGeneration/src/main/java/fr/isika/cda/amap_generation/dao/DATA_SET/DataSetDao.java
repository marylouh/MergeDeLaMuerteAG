package fr.isika.cda.amap_generation.dao.DATA_SET;

import java.math.BigDecimal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.isika.cda.amap_generation.model.amap.ActivityCenterRental;
import fr.isika.cda.amap_generation.model.amap.ActivityType;
import fr.isika.cda.amap_generation.model.amap.Amap;
import fr.isika.cda.amap_generation.model.amap.AmapAdministrator;
import fr.isika.cda.amap_generation.model.amap.BasketFormula;
import fr.isika.cda.amap_generation.model.amap.BasketRental;
import fr.isika.cda.amap_generation.model.amap.Event;
import fr.isika.cda.amap_generation.model.amap.NameOfFormula;
import fr.isika.cda.amap_generation.model.amap.ShopRental;
import fr.isika.cda.amap_generation.model.amap.Status;
import fr.isika.cda.amap_generation.model.amap.TypeOfRentalFormulas;
import fr.isika.cda.amap_generation.model.amap.Workshop;
import fr.isika.cda.amap_generation.model.supplier.Basket;
import fr.isika.cda.amap_generation.model.supplier.Basket.seasonState;
import fr.isika.cda.amap_generation.model.supplier.BasketProduct;
import fr.isika.cda.amap_generation.model.supplier.BasketProductType;
import fr.isika.cda.amap_generation.model.supplier.BioCertification;
import fr.isika.cda.amap_generation.model.supplier.ShopProduct;
import fr.isika.cda.amap_generation.model.supplier.Supplier;
import fr.isika.cda.amap_generation.model.user.Address;
import fr.isika.cda.amap_generation.model.user.Administrator;
import fr.isika.cda.amap_generation.model.user.Gender;
import fr.isika.cda.amap_generation.model.user.Member;
import fr.isika.cda.amap_generation.model.user.PersonType;
import fr.isika.cda.amap_generation.model.user.Registered;
import fr.isika.cda.amap_generation.model.user.TypeOfMember;
import fr.isika.cda.amap_generation.model.user.TypeOfPlace;
import fr.isika.cda.amap_generation.utils.DateUtils;

@Stateless
public class DataSetDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void persistence() {

		// Adresses

		Address address = new Address();
		address.setNameOfPlace("de la concorde");
		address.setNumber("5698");
		address.setPostalCode("01458");
		address.setTown("Paris");
		address.setTypeOfPlace(TypeOfPlace.PLACE);

		Address sdAddress = new Address();
		sdAddress.setNameOfPlace("du code java");
		sdAddress.setNumber("52");
		sdAddress.setPostalCode("38000");
		sdAddress.setTown("Grenoble");
		sdAddress.setTypeOfPlace(TypeOfPlace.IMPASSE);

		Address tdAddress = new Address();
		tdAddress.setNameOfPlace("merge");
		tdAddress.setNumber("21");
		tdAddress.setPostalCode("69355");
		tdAddress.setTown("Lyon");
		tdAddress.setTypeOfPlace(TypeOfPlace.AVENUE);

		Address ftAddress = new Address();
		ftAddress.setNameOfPlace("biologique");
		ftAddress.setNumber("35");
		ftAddress.setPostalCode("59125");
		ftAddress.setTown("Lille");
		ftAddress.setTypeOfPlace(TypeOfPlace.RUE);

		// BioCertification

		BioCertification bioCertif = new BioCertification();
		bioCertif.setDateOfEntry(DateUtils.formDate(2022, 01, 01));
		bioCertif.setDuration(12);
		bioCertif.setIsValid(true);

		entityManager.persist(bioCertif);

		//
		BioCertification firstBioCertif = new BioCertification();
		firstBioCertif.setDateOfEntry(DateUtils.formDate(2022, 02, 06));
		firstBioCertif.setDuration(13);
		firstBioCertif.setIsValid(true);

		entityManager.persist(firstBioCertif);

		//
		BioCertification secondBioCertif = new BioCertification();
		secondBioCertif.setDateOfEntry(DateUtils.formDate(2022, 02, 01));
		secondBioCertif.setDuration(12);
		secondBioCertif.setIsValid(true);

		entityManager.persist(secondBioCertif);

		BioCertification thirdBioCertif = new BioCertification();
		thirdBioCertif.setDateOfEntry(DateUtils.formDate(2021, 12, 04));
		thirdBioCertif.setDuration(12);
		thirdBioCertif.setIsValid(true);

		entityManager.persist(thirdBioCertif);

		// ---------- ACTIVITIES ------------
		// Event

		Event ev = new Event();

		ev.setActivityName("Foire aux légumes");
		ev.setActivityDate(DateUtils.formDate(2022, 01, 15));

		ev.setNumberOfParticipants(6);
		ev.setShortDescription("Tous les légumes de chez vous.");
		ev.setProgramDescription("09h-15h : Venez découvrir la diversité agricole de vos régions.");
		ev.setActivityType(ActivityType.EVENT);

		entityManager.persist(ev);

		// Workshop

		Workshop ws = new Workshop();
		ws.setActivityName("Mes Beaux Légumes");
		ws.setActivityDate(DateUtils.formDate(2022, 03, 23));
		ws.setNumberOfParticipants(6);
		ws.setShortDescription("Un atelier très sympa !");
		ws.setProgramDescription("14h-15h : Création de bocaux de légumes lacto-fermentés.");
		ws.setActivityType(ActivityType.WORKSHOP);

		entityManager.persist(ws);

		Event sdEv = new Event();
		sdEv.setActivityName("Légume bio ou pas bio?");
		sdEv.setActivityDate(DateUtils.formDate(2021, 05, 01));
		sdEv.setNumberOfParticipants(8);
		sdEv.setShortDescription("Dégustez pour voir !");
		sdEv.setProgramDescription("11h-13h : Légumes bio à ramener chez vous, venez vite !");
		sdEv.setActivityType(ActivityType.EVENT);

		entityManager.persist(sdEv);

		// Workshop

		Workshop sdWs = new Workshop();
		sdWs.setActivityName("Comment cultiver ses légumes l'hiver?");
		sdWs.setActivityDate(DateUtils.formDate(2021, 02, 21));
		sdWs.setNumberOfParticipants(5);
		sdWs.setShortDescription("Initiation permaculture de l'hiver.");
		sdWs.setProgramDescription("15h-17h : nos légumes face aux tourments de l'hiver.");
		sdWs.setActivityType(ActivityType.WORKSHOP);

		entityManager.persist(sdWs);

		Event thEv = new Event();
		thEv.setActivityName("Petit marché bio");
		thEv.setActivityDate(DateUtils.formDate(2022, 02, 10));
		thEv.setNumberOfParticipants(15);
		thEv.setShortDescription("Des légumes bio si proches de vous !");
		thEv.setProgramDescription("08h-13h : Oyez, Oyez, venez vite achetez vos légumes tout mignons");
		thEv.setActivityType(ActivityType.EVENT);

		entityManager.persist(thEv);

		// Workshop

		Workshop thWs = new Workshop();
		thWs.setActivityName("Plantation des légumes tropicaux");
		thWs.setActivityDate(DateUtils.formDate(2022, 9, 21));
		thWs.setNumberOfParticipants(6);
		thWs.setShortDescription("Des kiwis chez vous");
		thWs.setProgramDescription("10h-13h : Les îles tropicales dans votre jardin");
		thWs.setActivityType(ActivityType.WORKSHOP);

		entityManager.persist(thWs);

		Event fhEv = new Event();
		fhEv.setActivityName("Réunion de petits producteurs");
		fhEv.setActivityDate(DateUtils.formDate(2021, 04, 02));
		fhEv.setNumberOfParticipants(10);
		fhEv.setShortDescription("Entraide entre producteurs");
		fhEv.setProgramDescription(
				"16h-18h : Rencontres, astuces et partage de savoir-faire entre producteurs de légumes bio.");
		fhEv.setActivityType(ActivityType.EVENT);

		entityManager.persist(fhEv);

		// Workshop

		Workshop fhWs = new Workshop();
		fhWs.setActivityName("Plantations, Cueillette et dégustations! ");
		fhWs.setActivityDate(DateUtils.formDate(2022, 03, 23));
		fhWs.setNumberOfParticipants(6);
		fhWs.setShortDescription("Tout est dit dans le titre ;)");
		fhWs.setProgramDescription("10h-14h : Les légumes, de leur naissance à leur retour à la terre.");
		fhWs.setActivityType(ActivityType.WORKSHOP);

		entityManager.persist(fhWs);

		// Amap

		Amap firstAmap = new Amap();

		firstAmap.setDateOfSubscription(DateUtils.formDate(2022, 03, 01));
		firstAmap.setNameAmap("Les Faiseurs de Bio");
		firstAmap.setLocalisation(address);
		firstAmap.setRegisterStatus(Status.VALIDE);
		firstAmap.setSlogan("Nous, on aime les sites oldschool !");

		Amap secondAmap = new Amap();
		secondAmap.setDateOfSubscription(DateUtils.formDate(2021, 02, 01));
		secondAmap.setNameAmap("Amaporte");
		secondAmap.setLocalisation(sdAddress);
		secondAmap.setRegisterStatus(Status.VALIDE);
		secondAmap.setSlogan("Nous, on aime le gros back-end du turfu !");

		Amap thirdAmap = new Amap();
		thirdAmap.setDateOfSubscription(DateUtils.formDate(2021, 02, 02));
		thirdAmap.setNameAmap("Fresh & Wild");
		thirdAmap.setLocalisation(tdAddress);
		thirdAmap.setRegisterStatus(Status.VALIDE);
		thirdAmap.setSlogan("Nous, on aime les sites modernes !");

		Amap fourthAmap = new Amap();

		fourthAmap.setDateOfSubscription(DateUtils.formDate(2022, 03, 06));
		fourthAmap.setNameAmap("Dune de légumes");
		fourthAmap.setLocalisation(ftAddress);
		fourthAmap.setRegisterStatus(Status.ENCOURS);
		fourthAmap.setSlogan("Des fleurs et des champs :)");

		// Supplier

		Supplier firstSupProd = new Supplier();

		firstSupProd.setFirstName("Leroy");
		firstSupProd.setLastName("Rémi");
		firstSupProd.setLogin("lr");
		firstSupProd.setPassword("lr");
		firstSupProd.setSiretNumber("12512512545");
		firstSupProd.setGender(Gender.MONSIEUR);
		firstSupProd.setBioCertification(firstBioCertif);
		firstSupProd.setCompanyName("Manger Bio");
		firstSupProd.setDateOfEntry(DateUtils.formDate(2022, 01, 10));
		firstSupProd.setPersonType(PersonType.SUPPLIER);
		
		secondAmap.addSupplier(firstSupProd);

		entityManager.persist(secondAmap);

		//
		Supplier secondSupProd = new Supplier();

		secondSupProd.setFirstName("Senova");
		secondSupProd.setLastName("Laure");
		secondSupProd.setLogin("sl");
		secondSupProd.setPassword("sl");
		secondSupProd.setSiretNumber("12512512688");
		secondSupProd.setGender(Gender.MADAME);
		secondSupProd.setBioCertification(secondBioCertif);
		secondSupProd.setCompanyName("Bio pour tous");
		secondSupProd.setDateOfEntry(DateUtils.formDate(2022, 01, 18));
		secondSupProd.setPersonType(PersonType.SUPPLIER);

		thirdAmap.addSupplier(secondSupProd);

		entityManager.persist(thirdAmap);

		Supplier activitySupplier = new Supplier();

		ev.setSupplier(activitySupplier);
		ws.setSupplier(activitySupplier);
		fhEv.setSupplier(activitySupplier);
		fhWs.setSupplier(activitySupplier);

		activitySupplier.setFirstName("Corentin");
		activitySupplier.setLastName("Carotte");
		activitySupplier.setLogin("cc");
		activitySupplier.setAge(42);
		activitySupplier.setPassword("cc");
		activitySupplier.setSiretNumber("12512512541");
		activitySupplier.setGender(Gender.MONSIEUR);
		activitySupplier.setBioCertification(bioCertif);
		activitySupplier.setCompanyName("La Carotte Joyeuse");
		activitySupplier.setPersonType(PersonType.SUPPLIER);

		activitySupplier.setDateOfEntry(DateUtils.formDate(2022, 01, 10));
		activitySupplier.setSiretNumber("123456");

		fourthAmap.addSupplier(activitySupplier);

		entityManager.persist(fourthAmap);

		Supplier sndSupplier = new Supplier();

		sdEv.setSupplier(sndSupplier);
		sdWs.setSupplier(sndSupplier);
		thEv.setSupplier(sndSupplier);
		thWs.setSupplier(sndSupplier);

		sndSupplier.setFirstName("Mathilde");
		sndSupplier.setLastName("Dujardin");
		sndSupplier.setLogin("ma");
		sndSupplier.setAge(32);
		sndSupplier.setPassword("du");
		sndSupplier.setSiretNumber("1365843854387");
		sndSupplier.setGender(Gender.MADAME);
		sndSupplier.setBioCertification(thirdBioCertif);
		sndSupplier.setCompanyName("Les Marguerites sauvages");
		sndSupplier.setPersonType(PersonType.SUPPLIER);

		sndSupplier.setDateOfEntry(DateUtils.formDate(2021, 8, 10));
		sndSupplier.setSiretNumber("123456");

		firstAmap.addSupplier(sndSupplier);

		entityManager.persist(firstAmap);

		// Registereds

		Registered firstRegistered = new Registered();
		firstRegistered.setAmap(firstAmap);
		firstRegistered.setAge(31);
		firstRegistered.setAlias("La Patate");
		firstRegistered.setBirthDate(DateUtils.formDate(1990, 06, 24));
		firstRegistered.setFirstName("Jean");
		firstRegistered.setLastName("Guy");
		firstRegistered.setGender(Gender.MONSIEUR);
		firstRegistered.setLogin("JG");
		firstRegistered.setPassword("jg");
		firstRegistered.setPersonType(PersonType.REGISTERED);

		entityManager.persist(firstRegistered);

		firstAmap.addRegistered(firstRegistered);
		
//		entityManager.merge(firstAmap);

		Registered secondRegistered = new Registered();
		secondRegistered.setAmap(secondAmap);
		secondRegistered.setAge(42);
		secondRegistered.setAlias("Yvy");
		secondRegistered.setBirthDate(DateUtils.formDate(1980, 02, 02));
		secondRegistered.setFirstName("Yvette");
		secondRegistered.setLastName("Kolt");
		secondRegistered.setGender(Gender.MADAME);
		secondRegistered.setLogin("Y.kolt@gmail.com");
		secondRegistered.setPassword("yk");
		secondRegistered.setPersonType(PersonType.REGISTERED);

		entityManager.persist(secondRegistered);

		secondAmap.addRegistered(secondRegistered);
		
//		entityManager.merge(secondAmap);

		Registered thirdRegistered = new Registered();
		thirdRegistered.setAmap(thirdAmap);
		thirdRegistered.setAge(39);
		thirdRegistered.setAlias("JCVD");
		thirdRegistered.setBirthDate(DateUtils.formDate(1982, 06, 03));
		thirdRegistered.setFirstName("Sophie");
		thirdRegistered.setLastName("Regina");
		thirdRegistered.setGender(Gender.MADAME);
		thirdRegistered.setLogin("s.regina@gmail.com");
		thirdRegistered.setPassword("sr");
		thirdRegistered.setPersonType(PersonType.REGISTERED);

		entityManager.persist(thirdRegistered);

		thirdAmap.addRegistered(thirdRegistered);
		
//		entityManager.merge(thirdAmap);

		// AmapAdministrator

		AmapAdministrator awm = new AmapAdministrator();
		awm.setLoginAwm("adminFDB");
		awm.setPasswordAwm("admin");
		entityManager.persist(awm);

		thirdAmap.addWebMaster(awm);

		// Member

		Member firstMember = new Member();
		firstMember.setRegistered(firstRegistered);
		firstMember.setTypeOfMember(TypeOfMember.PARTICULIER);

		entityManager.persist(firstMember);
		firstRegistered.setMember(firstMember);
		entityManager.merge(firstRegistered);

		Member secondMember = new Member();
		secondMember.setRegistered(secondRegistered);
		secondMember.setTypeOfMember(TypeOfMember.PARTICULIER);

		entityManager.persist(secondMember);
		secondRegistered.setMember(secondMember);
		entityManager.merge(secondRegistered);

		Member thirdMember = new Member();
		thirdMember.setRegistered(thirdRegistered);
		thirdMember.setTypeOfMember(TypeOfMember.CE);

		entityManager.persist(thirdMember);
		thirdRegistered.setMember(thirdMember);
		entityManager.merge(thirdRegistered);

		// Les Produits

		ShopProduct firstShopProd = new ShopProduct();
		ShopProduct secondShopProd = new ShopProduct();
		ShopProduct thirdShopProd = new ShopProduct();
		ShopProduct forrthShopProd = new ShopProduct();

		BasketProduct bprod1 = new BasketProduct();
		BasketProduct bprod2 = new BasketProduct();
		BasketProduct bprod3 = new BasketProduct();
		BasketProduct bprod4 = new BasketProduct();

		Basket bp1 = new Basket();
//				Basket bp2 = new Basket();
//				Basket bp3 = new Basket();

		// Les produit boutiques
		firstShopProd.setName("Pommes");
		firstShopProd.setPrice(null);
		firstShopProd.setDateOfCreation(DateUtils.formDate(2022, 03, 01));
		firstShopProd.setSupplier(firstSupProd);
		entityManager.persist(firstShopProd);

		secondShopProd.setName("Miel");
		secondShopProd.setPrice(null);
		secondShopProd.setDateOfCreation(DateUtils.formDate(2022, 03, 01));
		secondShopProd.setSupplier(firstSupProd);
		entityManager.persist(secondShopProd);

		thirdShopProd.setName("Confiture de fraise");
		thirdShopProd.setPrice(null);
		thirdShopProd.setDateOfCreation(DateUtils.formDate(2022, 02, 18));
		thirdShopProd.setSupplier(secondSupProd);
		entityManager.persist(thirdShopProd);

		forrthShopProd.setName("Pâté");
		forrthShopProd.setPrice(null);
		forrthShopProd.setDateOfCreation(DateUtils.formDate(2022, 02, 18));
		forrthShopProd.setSupplier(secondSupProd);
		entityManager.persist(forrthShopProd);

		// les produits paniers

		bprod1.setName("Orange");
		bprod1.setShortDescription("Belle couleur");
		bprod1.setPrice(BigDecimal.valueOf(0.5d));
		bprod1.setDateOfCreation(DateUtils.formDate(2022, 03, 05));
		bprod1.setQuantity(3);
		bprod1.setBasketProductType(BasketProductType.FRUITS);
		bprod1.setSupplier(firstSupProd);
		bprod1.setBasket(bp1);
		entityManager.persist(bprod1);

		bprod2.setName("Tomate");
		bprod2.setShortDescription("Juteuse");
		bprod2.setPrice(BigDecimal.valueOf(0.5d));
		bprod2.setDateOfCreation(DateUtils.formDate(2022, 03, 05));
		bprod2.setQuantity(5);
		bprod2.setBasketProductType(BasketProductType.VEGETABLES);
		bprod2.setSupplier(firstSupProd);
		bprod2.setBasket(bp1);
		entityManager.persist(bprod2);

		bprod3.setName("Côte de porc");
		bprod3.setShortDescription("Qualité supérieure");
		bprod3.setPrice(BigDecimal.valueOf(5d));
		bprod3.setDateOfCreation(DateUtils.formDate(2022, 03, 05));
		bprod3.setQuantity(2);
		bprod3.setBasketProductType(BasketProductType.MEAT);
		bprod3.setSupplier(firstSupProd);
		bprod3.setBasket(bp1);
		entityManager.persist(bprod3);

		bprod4.setName("Pomme");
		bprod4.setShortDescription("Granny Smith");
		bprod4.setPrice(BigDecimal.valueOf(0.6d));
		bprod4.setDateOfCreation(DateUtils.formDate(2022, 03, 05));
		bprod4.setQuantity(5);
		bprod4.setBasketProductType(BasketProductType.FRUITS);
		bprod4.setSupplier(firstSupProd);
		bprod4.setBasket(bp1);
		entityManager.persist(bprod4);

		// Basket Solo

		bp1.setName("Panier Solo");
		bp1.setAvailable(true);
		bp1.setNumberOfProducts(15);
		bp1.setSeason(seasonState.SPRING);
		entityManager.persist(bp1);

		Administrator administrator = new Administrator();
		administrator.setLoginAdmin("admin");
		administrator.setPasswordAdmin("admin");

		// Basket formulas

		BasketFormula bf1 = new BasketFormula();
		BasketFormula bf2 = new BasketFormula();
		BasketFormula bf3 = new BasketFormula();

		bf1.setNameOfFormulas(NameOfFormula.FORMULE_SOLO);
		bf1.setSubscriptionCost(BigDecimal.valueOf(336.0d));
		bf1.setDateOfSubscription(DateUtils.getTodaysDate());
		bf1.setFormulasDescription("Pour voir la vie en bio !");
		bf1.setActive(true);
		bf1.setAmap(firstAmap);
		bf1.setMember(firstMember);
		entityManager.persist(bf1);

		bf2.setNameOfFormulas(NameOfFormula.FORMULE_DUO);
		bf2.setSubscriptionCost(BigDecimal.valueOf(648.0d));
		bf2.setDateOfSubscription(DateUtils.getTodaysDate());
		bf2.setFormulasDescription("Pour partager la vie en bio !");
		bf2.setActive(true);
		bf2.setAmap(secondAmap);
		bf2.setMember(secondMember);
		entityManager.persist(bf2);

		bf3.setNameOfFormulas(NameOfFormula.FORMULE_FAMILY);
		bf3.setSubscriptionCost(BigDecimal.valueOf(1200.0d));
		bf3.setDateOfSubscription(DateUtils.getTodaysDate());
		bf3.setFormulasDescription("Pour bercer les enfants au bio !");
		bf3.setActive(true);
		bf3.setAmap(thirdAmap);
		bf3.setMember(thirdMember);
		entityManager.persist(bf3);

		
		// Rentals
		
				BasketRental br1 = new BasketRental();
				BasketRental br2 = new BasketRental();
				BasketRental br3 = new BasketRental();
				BasketRental br4 = new BasketRental();
				
				ShopRental sr1 = new ShopRental();
				ShopRental sr2 = new ShopRental();
				ShopRental sr3 = new ShopRental();
				
				ActivityCenterRental ar1 = new ActivityCenterRental();
				ActivityCenterRental ar2 = new ActivityCenterRental();
				
				br1.setAmap(firstAmap);
				br2.setAmap(secondAmap);
				br3.setAmap(thirdAmap);
				br4.setAmap(fourthAmap);
				
				sr1.setAmap(secondAmap);
				sr2.setAmap(thirdAmap);
				sr3.setAmap(fourthAmap);
				
				ar1.setAmap(thirdAmap);
				ar2.setAmap(fourthAmap);
				
				entityManager.persist(br1);
				entityManager.persist(br2);
				entityManager.persist(br3);
				entityManager.persist(br4);
				entityManager.persist(sr1);
				entityManager.persist(sr2);
				entityManager.persist(sr3);
				entityManager.persist(ar1);
				entityManager.persist(ar2);
				
				firstAmap.setTypeOfRentalFormulas(TypeOfRentalFormulas.FORMULE_1);
				secondAmap.setTypeOfRentalFormulas(TypeOfRentalFormulas.FORMULE_2);
				thirdAmap.setTypeOfRentalFormulas(TypeOfRentalFormulas.FORMULE3);
				fourthAmap.setTypeOfRentalFormulas(TypeOfRentalFormulas.FORMULE3);
				
				entityManager.merge(firstAmap);
				entityManager.merge(secondAmap);
				entityManager.merge(thirdAmap);
				entityManager.merge(fourthAmap);
		
	}

}
