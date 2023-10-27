package com.enigma.belajar_spring_boot.controller;

import com.enigma.belajar_spring_boot.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    // @RestController @Controller
    // endpoint/resources -> (/api/hello)
    // http://localhost:8080/api/hello

    // cara lama menggunakan request mapping
    // @RequestMapping(method = RequestMethod.GET, value = "/api/hello")

    // Cara baru
    @GetMapping("/api/hello")
    public Object helloWorld() {
        // java > 8
//		return new Object() {
//			private String hello = "Dita";
//
//			public String getHello() {
//				return hello;
//			}
//		};

        // java < 8
        Map<String, Object> data = new HashMap<>();
        Map<String, Object> address = new HashMap<>();

        address.put("street", "Jl. H. Dahlan");
        address.put("district", "Ragunan");
        address.put("city", "Jakarta Selatan");

        data.put("name", "Sehun");
        data.put("age", 29);
        data.put("hobbies", new String[] {"Makan", "Main sama hyung", "Main sama vivi"});
        data.put("address", address);
        return data;
    }

    // path variable -> untuk mencari data yang spesifik
    // @PathVariable -> untuk namanya tidak wajib jika sama dengan endpoint, namun jika berbeda maka wajib.
    @GetMapping("/api/customers/{id}")
    public Object hello(@PathVariable(name = "id") String id) {
        return "Customer " + id;
    }

    // request param / query param -> digunakan untuk melakukan filtering data
    // required = false -> artinya jika endpoint tidak diisi oleh user, maka tidak apa apa
    @GetMapping("/api/customers")
    public Object getCustomerFilter(@RequestParam(required = false) String name, @RequestParam(required = false) String city) {
        if (name == null && city == null) {
            throw new RuntimeException("Isi woy !");
        }
        return "Customer " + name + "<br>Alamat: " + city;
    }

    @PostMapping("/api/customers")
    // parameter itu request dari client
    // @RequestBody -> digunakan untuk client dapat mengirimkan data berupa JSON
    public Customer createCustomer(@RequestBody Customer customer) {
        // return -> hasil response server yang dikirim ke client
        return customer;
    }
}
