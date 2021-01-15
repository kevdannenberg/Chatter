package com.example.chatter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.chatter.database.ContactDatabase
import com.example.chatter.databinding.FragmentContactListBinding

/**
 * A fragment representing a list of Items.
 */
class ContactListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentContactListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_contact_list, container, false)
        val application = requireNotNull(this.activity).application
        val dataSource = ContactDatabase.getInstance(application).contactDatabaseDao
        val viewModelFactory = ContactListViewModelFactory(dataSource, application)
        val contactListViewModel = ViewModelProvider(this, viewModelFactory).get(ContactListViewModel::class.java)
        binding.contactListViewModel = contactListViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

}