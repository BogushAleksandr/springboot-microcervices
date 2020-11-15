package com.ua.sasha.bogush.springbootmicrocervices.service.servicenode;

import com.ua.sasha.bogush.springbootmicrocervices.model.modelnode.Entry;
import com.ua.sasha.bogush.springbootmicrocervices.model.modelnode.Permissions;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

public interface ServiceNode {
    Mono<Entry> getNodeOnNodesId(String nodeid);

    Mono<Entry> setPermissionsOnNodesId(String nodeid, Permissions permission);

    Mono<Entry> createNodeFromListOnNodesId(String nodeid, List<Entry> entry);

    Mono<Entry> createNodeOnNodesIds(String nodeid, Entry entry);

    Mono<Void> fullDelateNode(String nodeid);
}
