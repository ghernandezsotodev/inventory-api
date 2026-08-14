package dev.inventory.inventory_api.controller;

import dev.inventory.inventory_api.model.Server;
import dev.inventory.inventory_api.repository.ServerRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/servers")
public class ServerController {

    private final ServerRepository serverRepository;

    public ServerController(ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }

    @PostMapping
    public Server createServer(@RequestBody Server server){
        return serverRepository.save(server);
    }
}
