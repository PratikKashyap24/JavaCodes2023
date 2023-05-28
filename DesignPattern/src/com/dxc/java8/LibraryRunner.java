package com.dxc.java8;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class LibraryRunner {
public static void main(String[] args) {
	

	
	List<Library> l1=new ArrayList() {{
		add(new Library(10, "Hound", "Sherlock"));
		add(new Library(9, "Round", "Sherlock"));
		add(new Library(100, "Sound", "Sherlock"));
		add(new Library(1, "Nound", "lock"));
		add(new Library(198, "Yound", "lock"));
		add(new Library(null, null, null));
	}};
	Optional<Library> opt=Optional.ofNullable(l1.get(5));
	
	
	System.out.println(opt.isPresent());
//List kl1=l1.stream().map(i->i.getAuthor()).filter(i->i.equals("Sherlock")).distinct().collect(Collectors.toList());
//System.out.println(kl1.toString());
//	l1.stream().collect(Collector.)

String s1="sds\naas\nad";
System.out.println(s1.lines().collect(Collectors.toList()));

}
}