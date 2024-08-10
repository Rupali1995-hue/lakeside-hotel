package contract.management.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import contract.management.pdf.util.ExcelGenerator;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import contract.management.dto.ClientMasterDto;
import contract.management.entity.ClientMaster;
import contract.management.exception.ClientIdIsNotPrsent;
import contract.management.exception.ClientNameAlreadyExistsException;
import contract.management.service.AddAttachmentResponse;
import contract.management.service.ClientMasterService;
import contract.management.service.RequiresLogin;
import io.swagger.annotations.ApiOperation;

@RestController
@Configuration
public class ClientMasterController {
	
		@Autowired
		private ClientMasterService clientMasterService;
		
		@Autowired
		private RestTemplate restTemplate;
		
		
		@PostMapping("/addClient")
		 @ApiOperation(value = "Gets list of addClient",
         notes = "expects a valid sessionToken and Id of user as returned part of login response"
         )
		public ResponseEntity<ClientMaster> saveClientMasterData(@RequestBody  ClientMasterDto clientMasterDto) throws ClientNameAlreadyExistsException{
			ClientMaster saveClient = clientMasterService.saveClient(clientMasterDto);
			return new ResponseEntity<>(saveClient,HttpStatus.OK);
			
		}
		
		@PutMapping("/updateClient")
		public ResponseEntity<ClientMaster> updateClientData(@RequestBody ClientMasterDto clientMasterDto) throws ClientIdIsNotPrsent{
			ClientMaster updateClient = clientMasterService.updateClient(clientMasterDto);
			return new ResponseEntity<>(updateClient, HttpStatus.OK);
		}
		
		@GetMapping("/getClientId/{clientId}")
		public ResponseEntity<ClientMaster> getClientId(@PathVariable long clientId){
			ClientMaster clientId2 = clientMasterService.getClientId(clientId);
			return new ResponseEntity<>(clientId2,HttpStatus.OK);
			
		}
		
		@GetMapping("/getAllClients")
		public ResponseEntity<List<ClientMaster>> getAllClientData(){
			List<ClientMaster> allClientList = clientMasterService.getAllClientList();
			return new ResponseEntity<>(allClientList,HttpStatus.OK);
			
		}
		  @PostMapping(value = "/addAttachment", consumes = {"multipart/form-data"})
		    public boolean addAttachment(@RequestParam("clientId") long clientId , @RequestParam("fileName")String fileName ,  @RequestParam("file") @RequestPart("file")  MultipartFile file) {
		        if(file != null )
		        {
		            try {
		                clientMasterService.saveReplyAttachmentFileClientMaster(clientId,file, fileName);
		            } catch (Exception e) {
		                e.printStackTrace();
		            }
		        }
			return true;
		    }
		  
		    @GetMapping("/export-to-excelsheet")
		    public void exportIntoExcelFile(HttpServletResponse response) throws IOException {
		        response.setContentType("application/octet-stream");
		        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		        String currentDateTime = dateFormatter.format(new Date());

		        String headerKey = "Content-Disposition";
		        String headerValue = "attachment; filename=student" + currentDateTime + ".xlsx";
		        response.setHeader(headerKey, headerValue);

		        List <ClientMaster> listOfStudents = clientMasterService.getAllClientList();
		        ExcelGenerator generator = new ExcelGenerator(listOfStudents);
		        generator.generateExcelFile(response);
		    }


}
