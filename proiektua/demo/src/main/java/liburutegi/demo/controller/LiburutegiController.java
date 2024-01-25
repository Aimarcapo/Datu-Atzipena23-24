package liburutegi.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import liburutegi.demo.model.Geometry;
import liburutegi.demo.model.Liburutegia;
import liburutegi.demo.model.LiburutegiaRepository;
import liburutegi.demo.model.Properties;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
// Rest Apiaren
@RequestMapping(path = "/liburutegia")
public class LiburutegiController {
	@Autowired
	private LiburutegiaRepository liburutegiaRepository;

	@GetMapping()
	public @ResponseBody Iterable<Liburutegia> getAllLiburutegia(@RequestParam (value="codigo",required = false) Integer codigo) {
		
		if(codigo==null){
			return liburutegiaRepository.findAll();
		}else{
				return liburutegiaRepository.findByMunicipioCodigo(codigo);
		}
		
	}


	// Liburutegi bat ezabatzeko balio du,
	// ezabatu nahi dugun liburutegiaren izena jarri behar du
	@DeleteMapping(path = "/delete/{izena}")
	public ResponseEntity<Void> delete(@PathVariable String izena) {
		try {
			long zenbat = liburutegiaRepository.deleteByName(izena);
			System.out.println("Ezabatutako liburutegi kopurua🔆: " + zenbat);
			return ResponseEntity.ok().build();

		} catch (Exception ex) {
			System.out.println("Errorea " + izena + " liburutegia ezabatzerakoan. ");
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping(path = "/deleteBy/{direccion_codigo_postal}/{municipio_codigo}")
	public ResponseEntity<Void> deleteByAdress(@PathVariable int direccion_codigo_postal,
		@PathVariable int municipio_codigo) {

				try {
					long ezabatua = liburutegiaRepository.deleteByAdress(direccion_codigo_postal, municipio_codigo);
						System.out.println("Ezabatutako liburutegi kopurua🔆: " + ezabatua);
			return ResponseEntity.ok().build();
					
			
				} catch (Exception e) {
						System.out.println("Errorea  liburutegia ezabatzerakoan. ");
			return ResponseEntity.notFound().build();
				}
	}

	/**
	 * Creates a new library resource using the provided data through an endpoint.
	 *
	 * @param libroDTO A JSON string containing information to create the new
	 *                 library resource.
	 * @return A string indicating the success of the operation ("Saved").
	 */
	@PostMapping(path = "/create") // Liburutegi berri bat sortzeko erabiltzen den endpointa
	public @ResponseBody String add(@RequestBody String libroDTO) {
		JSONObject obj = new JSONObject(libroDTO);
		String Type="Feature";
		Properties p = new Properties(obj.getJSONObject("properties").getString("actividad_tipo"),
				obj.getJSONObject("properties").getString("nombre"),
				obj.getJSONObject("properties").getString("tipo_via_codigo"),
				obj.getJSONObject("properties").getString("tipo_via_descripcion"),
				obj.getJSONObject("properties").getString("direccion_nombre_via"),
				obj.getJSONObject("properties").getString("direccion_numero"),
				obj.getJSONObject("properties").getInt("direccion_codigo_postal"),
				obj.getJSONObject("properties").getInt("municipio_codigo"),
				obj.getJSONObject("properties").getString("municipio_nombre"),
				obj.getJSONObject("properties").getString("referencia"),
				obj.getJSONObject("properties").getString("web"),
				obj.getJSONObject("properties").getString("email"),
				obj.getJSONObject("properties").getInt("telefono"),
				obj.getJSONObject("properties").getLong("fax"),
				obj.getJSONObject("properties").getDouble("longitud"),
				obj.getJSONObject("properties").getDouble("latitud"),
				obj.getJSONObject("properties").getString("fecha_creacion"),
				obj.getJSONObject("properties").getString("fecha_actualizacion"));
				List<Double> coordinates = new ArrayList<Double>();
		coordinates.add(obj.getJSONObject("properties").getDouble("longitud"));
		coordinates.add(obj.getJSONObject("properties").getDouble("latitud"));
		Geometry g = new Geometry(obj.getJSONObject("geometry").getString("type"), coordinates);
		Liburutegia liburutegia = new Liburutegia(Type,p,g);
		liburutegia.setGeometry(g);
		System.out.println(liburutegia.toString());
		liburutegiaRepository.save(liburutegia);

		return "Saved";
	}

	/**
	 * Updates the contact information for a library resource based on the provided
	 * data.
	 * 
	 * @param libroDTO A JSON string containing information to update the library
	 *                 resource.
	 * @param izena    The name of the library resource to update.
	 * @return ResponseEntity with HTTP status:
	 *         - 200 OK if the update was successful.
	 *         - 404 Not Found if the resource with the given name was not found or
	 *         an error occurred.
	 */
	@PutMapping(value = "/update/{izena}")
	public ResponseEntity<Liburutegia> updateContact(@Valid @RequestBody String libroDTO,
			@PathVariable String izena) {
		try {
			Liburutegia liburutegia = liburutegiaRepository.findByName(izena);
			JSONObject obj = new JSONObject(libroDTO);
			

			Properties p = new Properties(obj.getJSONObject("properties").getString("actividad_tipo"),
					obj.getJSONObject("properties").getString("nombre"),
					obj.getJSONObject("properties").getString("tipo_via_codigo"),
					obj.getJSONObject("properties").getString("tipo_via_descripcion"),
					obj.getJSONObject("properties").getString("direccion_nombre_via"),
					obj.getJSONObject("properties").getString("direccion_numero"),
					obj.getJSONObject("properties").getInt("direccion_codigo_postal"),
					obj.getJSONObject("properties").getInt("municipio_codigo"),
					obj.getJSONObject("properties").getString("municipio_nombre"),
					obj.getJSONObject("properties").getString("referencia"),
					obj.getJSONObject("properties").getString("web"),
					obj.getJSONObject("properties").getString("email"),
					obj.getJSONObject("properties").getInt("telefono"),
					obj.getJSONObject("properties").getLong("fax"),
					obj.getJSONObject("properties").getDouble("longitud"),
					obj.getJSONObject("properties").getDouble("latitud"),
					obj.getJSONObject("properties").getString("fecha_creacion"),
					obj.getJSONObject("properties").getString("fecha_actualizacion"));
					List<Double> coordinates = new ArrayList<Double>();
			coordinates.add(obj.getJSONObject("properties").getDouble("longitud"));
			coordinates.add(obj.getJSONObject("properties").getDouble("latitud"));

			Geometry g = new Geometry(obj.getJSONObject("geometry").getString("type"), coordinates);
			liburutegia.setType("Feauture");
			liburutegia.setProperties(p);
			liburutegia.setGeometry(g);
			System.out.println(liburutegia.toString());
			liburutegiaRepository.save(liburutegia);

			return ResponseEntity.ok().build();

		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.notFound().build();
		}
	}
}
