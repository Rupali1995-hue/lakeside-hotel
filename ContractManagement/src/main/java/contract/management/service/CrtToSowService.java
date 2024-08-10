package contract.management.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import contract.management.dto.CrtToSowDto;
import contract.management.entity.ClientMaster;
import contract.management.entity.CrtToSow;
import contract.management.repository.CrtToSowRepository;

@Service
public class CrtToSowService {
	@Autowired
	CrtToSowRepository crtToSowRepository;
	
    @Value("${temp_attachment_path}")
    private String tempAttachmentPathCrtToSaw;
   private static final Logger logger = LoggerFactory.getLogger(CrtToSowService.class);

	
	public CrtToSow savecrToSow(CrtToSowDto crtToSowDto) {
		CrtToSow crtToSow = new CrtToSow();
		crtToSow.setCrId(crtToSowDto.getCrId());
		crtToSow.setCrName(crtToSowDto.getCrName());
		crtToSow.setAmount(crtToSowDto.getAmount());
		crtToSow.setCrStatus(crtToSowDto.getCrStatus());
		CrtToSow save = crtToSowRepository.save(crtToSow);
		return save;
		
	}
	
	public CrtToSow updateCrtToSow(CrtToSowDto crtToSowDto) {
		Optional<CrtToSow> findById = crtToSowRepository.findById(crtToSowDto.getCrId());
		if(findById.isPresent()) {
			CrtToSow crtToSow =new CrtToSow();
			crtToSow.setCrId(crtToSowDto.getCrId());
			crtToSow.setCrName(crtToSowDto.getCrName());
			crtToSow.setAmount(crtToSowDto.getAmount());
			crtToSow.setCrStatus(crtToSowDto.getCrStatus());
			CrtToSow updateClient = crtToSowRepository.save(crtToSow);
			return updateClient;

		}
		return null;
		
	}
	
	public CrtToSow findByCrId(long id) {
		Optional<CrtToSow> findById = crtToSowRepository.findById(id);
		return findById.get();
		
	}
	
	public List<CrtToSow> findAllCrtToSowList()
	{
		List<CrtToSow> findAll = crtToSowRepository.findAll();
		return findAll;
	}
	
	
    public boolean saveReplyAttachmentFile(long crId, MultipartFile file, String fileName)throws Exception
    {

        try {
            Optional<CrtToSow> iqdEmailDetailsOptional = Optional.empty();
            if (iqdEmailDetailsOptional.isPresent()) {
                File directory = new File(getTempAttachmentsDirectoryCrtToSaw(crId));
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


    private String getTempAttachmentsDirectoryCrtToSaw( long crId)
    {
		return tempAttachmentPathCrtToSaw+File.separator+File.separator+crId;
    }


}
