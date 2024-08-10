package contract.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import contract.management.dto.CrtToSowDto;
import contract.management.entity.CrtToSow;
import contract.management.service.CrtToSowService;

@RestController
public class CrtToSowController {
	
	@Autowired
	private CrtToSowService crtToSowService;
	
	@PostMapping("/saveCrtToSow")
	public ResponseEntity<CrtToSow> saveCrtToSow(@RequestBody CrtToSowDto crtToSowDto){
		CrtToSow savecrToSow = crtToSowService.savecrToSow(crtToSowDto);
		return new ResponseEntity<>(savecrToSow,HttpStatus.OK);
		
	}
	
	@PutMapping("/updateCrtToSow")
	public ResponseEntity<CrtToSow> updateCrtToSow(@RequestBody CrtToSowDto crtToSowDto){
		CrtToSow updateCrtToSow = crtToSowService.updateCrtToSow(crtToSowDto);
		return new ResponseEntity<>(updateCrtToSow,HttpStatus.OK);
		
	}
	
	@GetMapping("/getCrId/{crId}")
	public ResponseEntity<CrtToSow> getCrId(@PathVariable long crId){
		CrtToSow findByCrId = crtToSowService.findByCrId(crId);
		return  new ResponseEntity<>(findByCrId,HttpStatus.OK);
		
	}
	 @GetMapping("/getALLCrId")
	 public ResponseEntity <List<CrtToSow>> getAllCrIdList(){
		 List<CrtToSow> findAllCrtToSowList = crtToSowService.findAllCrtToSowList();
		return new ResponseEntity<>(findAllCrtToSowList,HttpStatus.OK);
		 
	 }
	
	  @PostMapping(value = "/addAttachmentCrtToSaw", consumes = {"multipart/form-data"})
	    public boolean addAttachmentCrtToSaw(@RequestParam("crId") long clientId , @RequestParam("fileName")String fileName ,  @RequestParam("file") @RequestPart("file")  MultipartFile file) {
	        if(file != null )
	        {
	            try {
	            	crtToSowService.saveReplyAttachmentFile(clientId,file, fileName);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
		return true;
	    }


}
