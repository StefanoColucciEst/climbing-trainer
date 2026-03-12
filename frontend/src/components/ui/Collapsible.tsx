import { useState } from 'react'
import { ChevronDown } from 'lucide-react'

interface CollapsibleProps {
  title: string
  defaultOpen?: boolean
  children: React.ReactNode
}

export function Collapsible({ title, defaultOpen = false, children }: CollapsibleProps) {
  const [open, setOpen] = useState(defaultOpen)

  return (
    <div>
      <button
        type="button"
        onClick={() => setOpen(!open)}
        className="flex items-center justify-between w-full py-3 text-sm font-semibold text-text"
      >
        {title}
        <ChevronDown className={`w-4 h-4 text-text-secondary transition-transform duration-200 ${open ? 'rotate-180' : ''}`} />
      </button>
      <div className={`overflow-hidden transition-all duration-200 ${open ? 'max-h-[1000px] opacity-100' : 'max-h-0 opacity-0'}`}>
        {children}
      </div>
    </div>
  )
}
