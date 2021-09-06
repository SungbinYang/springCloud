package me.sungbin.eventapp.storage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.sungbin.eventapp.event.FileEvent;
import me.sungbin.eventapp.event.FileEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileService {

    final FileEventPublisher fileEventPublisher;

    public void fileUpload(Map<String, Object> data) {
      try {
          log.info("파일 복사 완료");
          log.info("DB 메타 정보 저장 완료");
          FileEvent completeEvent = FileEvent.toCompleteEvent(data);
          fileEventPublisher.notifyComplete(completeEvent);
      } catch (Exception e) {
          log.error("file upload fail: ", e);
          FileEvent errorEvent = FileEvent.toErrorEvent(data);
          fileEventPublisher.notifyError(errorEvent);
      }
    }
}
