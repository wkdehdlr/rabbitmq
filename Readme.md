### How to Start
- docker run -d --hostname my-rabbit --name some-rabbit -p 5672:5672 -p 15672:15672 rabbitmq:3-management

### yml
- 테스트를 위해서 리스너를 해제
```yaml
    listener:
      simple:
        auto-startup: false
``` 