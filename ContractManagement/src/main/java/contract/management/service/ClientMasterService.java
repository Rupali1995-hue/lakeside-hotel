package contract.management.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import contract.management.dto.ClientMasterDto;
import contract.management.entity.ClientMaster;
import contract.management.exception.ClientIdIsNotPrsent;
import contract.management.exception.ClientNameAlreadyExistsException;
import contract.management.repository.ClientMasterRepository;

@Service
public class ClientMasterService {
	
	@Autowired
	private ClientMasterRepository clientMasterRepository;
	
    @Value("${temp_attachment_path}")
     private String tempAttachmentPath;
    
    @Value("${reply_template_path}")
    private String replyAttachmentPath;
    private static final Logger logger = LoggerFactory.getLogger(ClientMasterService.class);

	
	public ClientMaster saveClient(ClientMasterDto clientMasterDto) throws ClientNameAlreadyExistsException{
		 
		ClientMaster foundUser = clientMasterRepository.findByClientNameIgnoreCase(clientMasterDto.getClientName());

        if(foundUser != null)
        {
            throw new ClientNameAlreadyExistsException("client name already exists with userName "+foundUser.getClientName());
        }

		ClientMaster clientMaster = new ClientMaster();
		clientMaster.setClientName(clientMasterDto.getClientName());
	//	clientMaster.setAttachment(clientMasterDto.getAttachment());
		clientMaster.setCity(clientMasterDto.getCity());
		clientMasterDto.setCountry(clientMasterDto.getCountry());
		clientMaster.setDeliveryHead(clientMasterDto.getDeliveryHead());
		clientMaster.setEndDate(clientMasterDto.getEndDate());
		clientMaster.setLocation(clientMasterDto.getLocation());
		clientMaster.setProjectManager(clientMasterDto.getProjectManager());
		clientMaster.setSalesHead(clientMasterDto.getSalesHead());
		clientMaster.setStartDate(clientMasterDto.getStartDate());
		ClientMaster client = clientMasterRepository.save(clientMaster);
		return client;
		
	}
	
	public ClientMaster updateClient(ClientMasterDto clientMasterDto) throws ClientIdIsNotPrsent {
		Optional<ClientMaster> findById = clientMasterRepository.findById(clientMasterDto.getClientId());
		if(findById.isPresent()) {
			ClientMaster clientMaster = findById.get();
			clientMaster.setClientName(clientMasterDto.getClientName());
			//	clientMaster.setAttachment(clientMasterDto.getAttachment());
				clientMaster.setCity(clientMasterDto.getCity());
				clientMasterDto.setCountry(clientMasterDto.getCountry());
				clientMaster.setDeliveryHead(clientMasterDto.getDeliveryHead());
				clientMaster.setEndDate(clientMasterDto.getEndDate());
				clientMaster.setLocation(clientMasterDto.getLocation());
				clientMaster.setProjectManager(clientMasterDto.getProjectManager());
				clientMaster.setSalesHead(clientMasterDto.getSalesHead());
				clientMaster.setStartDate(clientMasterDto.getStartDate());
				ClientMaster save = clientMasterRepository.save(clientMaster);
				return save;
		}
		else
		{
			throw new ClientIdIsNotPrsent("Client id is not present");
		}
		
		
	}

	public ClientMaster getClientId(Long clientId) {
		Optional<ClientMaster> findById = clientMasterRepository.findById(clientId);
		//ClientMaster clientMaster = findById.get();
		return findById.get();
		
	}
	
	public List<ClientMaster> getAllClientList(){
		List<ClientMaster> findAll = clientMasterRepository.findAll();
		return findAll;
		
	}
	
    public boolean saveReplyAttachmentFileClientMaster(long clientId, MultipartFile file, String fileName)throws Exception
    {

        try {
            Optional<ClientMaster> iqdEmailDetailsOptional = clientMasterRepository.findById(clientId);
            if (iqdEmailDetailsOptional.isPresent()) {
                File directory = new File(getTempAttachmentsDirectoryClientMaster(clientId));
                if (!directory.exists())
                    directory.mkdirs();

                File f = new File(directory.getPath() + File.separator + fileName);
                FileOutputStream fos = new FileOutputStream(f);
                InputStream attachmentInputStream = file.getInputStream();
                byte[] buf = new byte[4096];
                int bytesRead;
                while ((bytesRead = attachmentInputStream.read(buf)) != -1) {
                    fos.write(buf, 0, bytesRead);
                }
                fos.flush();
                fos.close();
                attachmentInputStream.close();

                return true;
            }
            return false;
        }catch (Exception ex)
        {
            logger.debug("error adding attachment"+ex.getMessage());
            return false;
        }
    }


    private String getTempAttachmentsDirectoryClientMaster(long clientId) {
		// TODO Auto-generated method stub
		return replyAttachmentPath+File.separator+File.separator+clientId;
	}


}
