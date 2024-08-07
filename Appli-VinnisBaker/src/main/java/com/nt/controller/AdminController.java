package com.nt.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.aspectj.apache.bcel.util.ClassPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nt.dto.ProductDTO;
import com.nt.entity.Category;
import com.nt.entity.Product;
import com.nt.entity.User;
import com.nt.service.IProductService;
import com.nt.service.IService;
import com.nt.service.IUserService;


@Controller
public class AdminController {
	
//	private final String uploadDir = System.getProperty("user.dir")+"src/main/resources/static/productImage";
//	private final String uploadDir = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "static", "productImage").toString();
	
	@Autowired
	private IService service;
	
	@Autowired
	private IProductService productservice;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private IUserService userservice;
	
	@GetMapping("/admin")
	public String adminhome(){
		return "adminhome";
	}
	
	@GetMapping("/createadmin")
	public String createAdmin() {
		User user = new User();
		user.setFirstName("vinay");
		user.setLastName("tanwar");
		user.setEmail("backer@123");
		user.setPassword(encoder.encode("123"));
		user.setRoles(new HashSet<String>(Set.of("ADMIN")));
		userservice.addUser(user);
		
		 return "CREATED";
	}
	
	@GetMapping("/admin/categories")
	public String categories(Map<String, Object> map) {
	 List<Category> list =	service.getallcategories();
	 map.put("categories", list);
	 return "categories";
	}
	
	@GetMapping("/admin/categories/add")
	public String getcategories(Map<String, Object> map) {
		map.put("category", new Category());
		return "addcategories";
	}
	
	@PostMapping("/admin/categories/add")
	public String addcategories(@ModelAttribute("category") Category category ,Map<String, Object> map) {
		service.addCategory(category);
		return "redirect:/admin/categories";
	}
	
	@GetMapping("/admin/categories/delete")
	public String deletecategory(@RequestParam("id") Integer id) {
		System.out.println(id);
		 service.delete(id);	
		return "redirect:/admin/categories";
	}
	
	@GetMapping("/admin/categories/update")
	public String getcategorytoupdate(@RequestParam("id") Integer id,Map<String, Object> map) {
       map.put("category",service.getByid(id));
		return "updatecategory";
	}
	
	@PostMapping("/admin/categories/updatecategory")
	public String updatecategory(@ModelAttribute("category") Category category) {
		
		service.addCategory(category);
		return "redirect:/admin/categories";
	}
	
	
	@GetMapping("/admin/products")
	public String showProducts(Map<String, Object> map) {
		map.put("products",productservice.getAllProduct());
		return "products";
	}
	
	@GetMapping("/admin/products/add")
	public String showaddproduct(Map<String, Object> map) {
		map.put("productDTO", new ProductDTO());
		map.put("categories", service.getallcategories());
		return"addProduct";
	}
	/*
	@PostMapping("/admin/products/add")
	public String addproducts(@ModelAttribute("productDTO") ProductDTO productdto,
			@RequestParam("productImage")MultipartFile imagefile,
			 @RequestParam("imgName")String imgname) {
		
		Product product = new Product();
		product.setId(productdto.getId());
		product.setName(productdto.getName());
		product.setCategory(service.getByid(productdto.getCategoryid()));
		product.setPrice(productdto.getPrice());
		product.setWeight(productdto.getWeight());
		product.setDescription(productdto.getDescription());
		String imageUUID;
		if(!imagefile.isEmpty()) {
			imageUUID = imagefile.getOriginalFilename();
		
//			Path filepath = Paths.get(uploadDir,imageUUID);
//			Files.write(filepath,imagefile.getBytes());
//			  FileUploadService fileUploadService = new FileUploadService();
//	            fileUploadService.saveFile(uploadDir, imageUUID, file.getBytes());
			   Path dirPath = Paths.get(uploadDir);
		        if (!Files.exists(dirPath)) {
		            try {
						Files.createDirectories(dirPath);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }

		        Path filePath = dirPath.resolve(imageUUID);
		        try {
					Files.write(filePath, imagefile.getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        System.out.println("File saved to: " + filePath.toString()); // Log the path

		}
		else {
			imageUUID=imgname;
			System.out.println("empty");
		}
		product.setImagename(imageUUID);
		productservice.saveproduct(product);
		
		return "redirect:/admin/products";
	}
	*/ 
	@PostMapping("/admin/products/add")
    public String addproducts(@ModelAttribute("productDTO") ProductDTO productdto,
            @RequestParam("productImage") MultipartFile imagefile  ) throws IOException {

					Product product = new Product();
					product.setId(productdto.getId());
					product.setName(productdto.getName());
					product.setImagename(imagefile.getOriginalFilename());
					product.setCategory(service.getByid(productdto.getCategoryid()));
					product.setPrice(productdto.getPrice());
					product.setWeight(productdto.getWeight());
					product.setDescription(productdto.getDescription());

					productservice.saveproduct(product);

					File savefile = new ClassPathResource("static/productImage").getFile();
					Path path = Paths.get(savefile.getAbsolutePath()+File.separator+imagefile.getOriginalFilename());
				    System.out.println(path);
					Files.copy(imagefile.getInputStream(),path,StandardCopyOption.REPLACE_EXISTING);

					return "redirect:/admin/products";
      }
	
	@GetMapping("/admin/product/delete")
	public String deleteProduct(@RequestParam("id") Integer id) {
		System.out.println(id);
		 productservice.delete(id);	
		return "redirect:/admin/products";
	}
	
	@GetMapping("/admin/product/update")
	public String showupdate(@RequestParam("id")Integer id,Map<String, Object> map) {
		
		Product product = productservice.findProduct(id);
		ProductDTO dto = new ProductDTO();
		dto.setId(product.getId());
		dto.setName(product.getName());
		dto.setCategoryid(product.getCategory().getId());
		dto.setDescription(product.getDescription());
		dto.setPrice(product.getPrice());
		dto.setWeight(product.getWeight());
		map.put("productDTO", dto);
		map.put("categories", service.getallcategories());
		
		return "addProduct";
	}
	
	

	 
}
