package com.dxc.cs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class shdsj {
public static void main(String[] args) {
	int x=4;
	int y=0;
	for(;y<5;++y) {
		if(y%x==0) {
			continue;
		}
		else if(y==7) {
			break;
		}
		else {
			System.out.println(y+" ");
		}
	}
	
}
}