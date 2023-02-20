package com.example.demo.service;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;


@Service
public class ProductService {

	private static final String COLLECTION_NAME = "products";

	public String saveProduct(Product product) throws InterruptedException, ExecutionException
	{
		Firestore dbFirestore=FirestoreClient.getFirestore();
	
		ApiFuture<WriteResult> collectionApiFuture=dbFirestore.collection(COLLECTION_NAME).document(product.getName()).set(product);
		return collectionApiFuture.get().getUpdateTime().toString();
	}
}
