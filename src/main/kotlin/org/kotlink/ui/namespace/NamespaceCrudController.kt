package org.kotlink.ui.namespace

import org.kotlink.api.namespace.NamespaceRepo
import org.kotlink.ui.SelectView
import org.kotlink.ui.UiView
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/ui/namespace")
class NamespaceCrudController(private val namespaceRepo: NamespaceRepo) {

    @GetMapping
    @SelectView(UiView.LIST_NAMESPACES)
    fun listNamespaces(model: Model): String {
        val namespaces = namespaceRepo.findAll()
        model.addAttribute("namespaces", namespaces)
        return "namespace/list"
    }
}